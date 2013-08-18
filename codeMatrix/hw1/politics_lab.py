voting_data = list(open("voting_record_dump109.txt"))

## Task 1

def create_voting_dict():
    """
    Input: None (use voting_data above)
    Output: A dictionary that maps the last name of a senator
            to a list of numbers representing the senator's voting
            record.
    Example: 
        >>> create_voting_dict()['Clinton']
        [-1, 1, 1, 1, 0, 0, -1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, -1, 1, 1, 1]

    This procedure should return a dictionary that maps the last name
    of a senator to a list of numbers representing that senator's
    voting record, using the list of strings from the dump file (strlist). You
    will need to use the built-in procedure int() to convert a string
    representation of an integer (e.g. '1') to the actual integer
    (e.g. 1).

    You can use the split() procedure to split each line of the
    strlist into a list; the first element of the list will be the senator's
    name, the second will be his/her party affiliation (R or D), the
    third will be his/her home state, and the remaining elements of
    the list will be that senator's voting record on a collection of bills.
    A "1" represents a 'yea' vote, a "-1" a 'nay', and a "0" an abstention.

    The lists for each senator should preserve the order listed in voting data. 
    """
    voteDict = {}
    for line in voting_data:
        lineList = line.split(" ")
        voteDict[lineList[0]] = [int(lineList[i]) for i in range(3,len(lineList))]
    return voteDict
    

## Task 2

def policy_compare(sen_a, sen_b, voting_dict):
    """
    Input: last names of sen_a and sen_b, and a voting dictionary mapping senator
           names to lists representing their voting records.
    Output: the dot-product (as a number) representing the degree of similarity
            between two senators' voting policies
    Example:
        >>> voting_dict = {'Fox-Epstein':[-1,-1,-1,1],'Ravella':[1,1,1,1]}
        >>> policy_compare('Fox-Epstein','Ravella', voting_dict)
        -2
    """
    vec_a = voting_dict[sen_a]
    vec_b = voting_dict[sen_b]
    return sum([vec_a[i]*vec_b[i] for i in range(0,len(vec_a))])


## Task 3

def most_similar(sen, voting_dict):
    """
    Input: the last name of a senator, and a dictionary mapping senator names
           to lists representing their voting records.
    Output: the last name of the senator whose political mindset is most
            like the input senator (excluding, of course, the input senator
            him/herself). Resolve ties arbitrarily.
    Example:
        >>> vd = {'Klein': [1,1,1], 'Fox-Epstein': [1,-1,0], 'Ravella': [-1,0,0]}
        >>> most_similar('Klein', vd)
        'Fox-Epstein'

    Note that you can (and are encouraged to) re-use you policy_compare procedure.
    """
    maxV = float("-inf")
    mostSim = ""
    for s in voting_dict.keys():
        if s != sen:
            tmpMax = policy_compare(sen,s,voting_dict)
            if tmpMax > maxV:
                maxV = tmpMax
                mostSim = s
    return mostSim
    

## Task 4

def least_similar(sen, voting_dict):
    """
    Input: the last name of a senator, and a dictionary mapping senator names
           to lists representing their voting records.
    Output: the last name of the senator whose political mindset is least like the input
            senator.
    Example:
        >>> vd = {'Klein': [1,1,1], 'Fox-Epstein': [1,-1,0], 'Ravella': [-1,0,0]}
        >>> least_similar('Klein', vd)
        'Ravella'
    """
    minV = float("inf")
    leastSim = ""
    for s in voting_dict.keys():
        if s != sen:
            tmpMin = policy_compare(sen,s,voting_dict)
            if tmpMin < minV:
                minV = tmpMin
                leastSim = s
    return leastSim
    
    

## Task 5

most_like_chafee    = "Jeffords"
least_like_santorum = "Feingold" 



# Task 6

def find_average_similarity(sen, sen_set, voting_dict):
    """
    Input: the name of a senator, a set of senator names, and a voting dictionary.
    Output: the average dot-product between sen and those in sen_set.
    Example:
        >>> vd = {'Klein': [1,1,1], 'Fox-Epstein': [1,-1,0], 'Ravella': [-1,0,0]}
        >>> find_average_similarity('Klein', {'Fox-Epstein','Ravella'}, vd)
        -0.5
    """
    similarity = [policy_compare(sen,senX,voting_dict) for senX in sen_set]
    return sum(similarity)/len(similarity)


def find_democrates():
    democrates = set([line.split(" ")[0] for line in voting_data if line.split(" ")[1] == "D"])
    return democrates

def find_republics():
    republics = set([line.split(" ")[0] for line in voting_data if line.split(" ")[1] == "R"])
    return republics

def most_average_with_democrates():
    """
    Use this procudure to compute which senator has the greatest average similarity
    with the set of Democrates
    """
    democrates = find_democrates()
    senators = set([line.split(" ")[0] for line in voting_data])
    maxAvg = float("-inf")
    maxAvgSen = ""
    voting_dict = create_voting_dict()
    for sen in senators:
        tmpMax = find_average_similarity(sen,democrates,voting_dict)
        if tmpMax > maxAvg:
            maxAvg = tmpMax
            maxAvgSen = sen
    return maxAvgSen


# give the last name (or code that computes the last name)
most_average_Democrat =  most_average_with_democrates()


# Task 7

def find_average_record(sen_set, voting_dict):
    """
    Input: a set of last names, a voting dictionary
    Output: a vector containing the average components of the voting records
            of the senators in the input set
    Example: 
        >>> voting_dict = {'Klein': [-1,0,1], 'Fox-Epstein': [-1,-1,-1], 'Ravella': [0,0,1]}
        >>> find_average_record({'Fox-Epstein','Ravella'}, voting_dict)
        [-0.5, -0.5, 0.0]
    """
    for s in voting_dict.keys():
        votesLen = len(voting_dict[s])
        break

    sumVec = [0]*votesLen
    for sen in sen_set:
        sumVec = [sumVec[i]+voting_dict[sen][i] for i in range(0,votesLen)]
    return [x/len(sen_set) for x in sumVec]


# (give the vector)
average_Democrat_record = find_average_record(find_democrates(),create_voting_dict())


# Task 8

def bitter_rivals(voting_dict):
    """
    Input: a dictionary mapping senator names to lists representing
           their voting records
    Output: a tuple containing the two senators who most strongly
            disagree with one another.
    Example: 
        >>> voting_dict = {'Klein': [-1,0,1], 'Fox-Epstein': [-1,-1,-1], 'Ravella': [0,0,1]}
        >>> bitter_rivals(voting_dict)
        ('Fox-Epstein', 'Ravella')
    """
    minDiff = float("inf")
    sen1 = ""
    sen2 = ""
    keys = voting_dict.keys()
    for s1 in keys:
        for s2 in keys:
            tmpDiff = policy_compare(s1,s2,voting_dict)
            print("s1 is %s, s2 is %s, and diff is %s " % (s1,s2,tmpDiff))
            if tmpDiff < minDiff:
                minDiff = tmpDiff
                sen1 = s1
                sen2 = s2
    return (sen1, sen2)

