# Please fill out this stencil and submit using the provided submission script.





## Problem 1
def myFilter(L, num): 
    new_list = [x for x in L if x % num != 0]
    return new_list


## Problem 2
def myLists(L):
    new_list = [[x for x in range(1,y+1)] for y in L]
    return new_list

## Problem 3
def myFunctionComposition(f, g):
    new_dic = {x:g[f[x]] for x in f}
    return new_dic


## Problem 4
# Please only enter your numerical solution.

complex_addition_a = 5 + 3j 
complex_addition_b = 0 + 1j
complex_addition_c = -1 + 0.001j
complex_addition_d = 0.001 + 9j



## Problem 5
GF2_sum_1 = 1
GF2_sum_2 = 0
GF2_sum_3 = 0


## Problem 6
def mySum(L): 
    sumL = 0
    for x in L:
        sumL += x
    return sumL


## Problem 7
def myProduct(L):
    prodL = 1
    for x in L:
        prodL *= x
    return prodL


## Problem 8
def myMin(L):
    minR = float('inf')


    for x in L:
        if x < minR:
            minR = x
    return minR

## Problem 9
def myConcat(L): 
    strL = ""
    for x in L:
        strL += x
    return strL



## Problem 10
def myUnion(L):
    rtnSet = set()
    for ele in L:
        rtnSet = rtnSet.union(ele)
    return rtnSet

