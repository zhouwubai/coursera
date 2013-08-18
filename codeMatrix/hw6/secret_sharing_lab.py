# version code 988
# Please fill out this stencil and submit using the provided submission script.

import random
from GF2 import one
from vecutil import list2vec
from vec import Vec
from independence import *

def randGF2():
    return random.randint(0,1)*one

## Problem 1
def randGF2(): 
    return random.randint(0,1)*one

domain = {0,1,2,3,4,5}

a0 = list2vec([one, one,   0, one,   0, one])
b0 = list2vec([one, one,   0,   0,   0, one])

def choose_secret_vector(s,t):
    u = Vec(a0.D,{})
    sumA = 0
    sumB = 0
    for i in range(5):
        u[i] = randGF2()
        sumA += a0[i] * u[i]
        sumB += b0[i] * u[i]
    u[5] = (t - sumB)/b0[5]
    if a0 * u != s:
        u[3] = u[3] + one
    return u


def randVec():
    return Vec(domain,{key:randGF2() for key in domain})



def generate_combine(num):
    choices = []
    for i in range(num):
        for j in range(i+1,num):
            for k in range(j+1, num):
                choices.append([i,j,k])
    return choices


## check every 3 pairs are independent
def check_independent(L):
    lenL = len(L)
    if lenL <= 6:
        if not is_independent(L):
            return False
        else:
            return True
    
    choices = generate_combine(int(lenL/2))
    for c in choices:
        testL = []
        testL.extend(L[2*c[0]:2*(c[0]+1)])
        testL.extend(L[2*c[1]:2*(c[1]+1)])
        testL.extend(L[2*c[2]:2*(c[2]+1)])
        print(len(testL))
        if not is_independent(testL):
            return False
    return True


## generate all 6-vectors on GF(2)
def iter_all_GF2():
    val = [0,one]
    return [Vec(domain,{0:a0,1:a1,2:a2,3:a3,4:a4,5:a5}) for a0 in val 
            for a1 in val for a2 in val for a3 in val for a4 in val for a5 in val  ]


## generate unequal pair
def rand_pair(s,b):
    num1 = random.randint(s,b)
    num2 = num1
    while(num1 == num2):
        num2 = random.randint(s,b)
    return (num1,num2)




def choose_pairs():
    allGF = iter_all_GF2()
    result = [a0,b0]
    while(len(result) != 10):
        (num1,num2) = rand_pair(0,len(allGF)-1)
        cand1 = allGF[num1]
        cand2 = allGF[num2]
        if cand1 not in result and cand2 not in result:
            result.extend([cand1,cand2])
            if not check_independent(result):
                result.pop()
                result.pop()
    return result


## Problem 2
# Give each vector as a Vec instance
secret_a0 = Vec(domain,{0:one,1:one,3:one,5:one})
secret_b0 = Vec(domain,{0:one,1:one,5:one})
secret_a1 = Vec(domain,{3:one,5:one})
secret_b1 = Vec(domain,{2:one,4:one,5:one})
secret_a2 = Vec(domain,{1:one,5:one})
secret_b2 = Vec(domain,{0:one,1:one,2:one,5:one})
secret_a3 = Vec(domain,{0:one,2:one,3:one,4:one,5:one})
secret_b3 = Vec(domain,{0:one,1:one,4:one,5:one})
secret_a4 = Vec(domain,{1:one,4:one,5:one})
secret_b4 = Vec(domain,{1:one})



