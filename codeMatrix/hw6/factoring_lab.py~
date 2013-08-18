from vec import Vec
from GF2 import one

from factoring_support import dumb_factor
from factoring_support import intsqrt
from factoring_support import gcd
from factoring_support import primes
from factoring_support import prod

from operator import mul
import echelon


## Task 1
def int2GF2(i):
    '''
    Returns one if i is odd, 0 otherwise.

    Input:
        - i: an int
    Output:
        - one if i is congruent to 1 mod 2
        - 0   if i is congruent to 0 mod 2
    Examples:
        >>> int2GF2(3)
        one
        >>> int2GF2(100)
        0
    '''
    return one if i % 2 != 0 else 0

## Task 2
def make_Vec(primeset, factors):
    '''
    Input:
        - primeset: a set of primes
        - factors: a list of factors [(p_1,a_1), ..., (p_n, a_n)]
                   with p_i in primeset
    Output:
        - a vector v over GF(2) with domain primeset
          such that v[p_i] = int2GF2(a_i) for all i
    Example:
        >>> make_Vec({2,3,11}, [(2,3), (3,2)]) == Vec({2,3,11},{2:one})
        True
    '''
    return Vec(primeset,{key:int2GF2(val) for (key,val) in factors})

## Task 3
def find_candidates(N, primeset):
    '''
    Input:
        - N: an int to factor
        - primeset: a set of primes

    Output:
        - a list [roots, rowlist]
        - roots: a list a_0, a_1, ..., a_n where a_i*a_i - N can be factored
                 over primeset
        - rowlist: a list such that rowlist[i] is a
                   primeset-vector over GF(2) corresponding to a_i
          such that len(roots) = len(rowlist) and len(roots) > len(primeset)
    '''
    roots = []
    rowlist = []
    base = intsqrt(N) + 1
    while(len(roots) <= len(primeset)):  ## len(roots) == len(primeset) + 1
        base += 1
        df = dumb_factor(base**2 - N,primeset)
        if df == []:
            continue
        roots.append(base)
        rowlist.append(make_Vec(primeset,df))
    return (roots,rowlist)



## Task 4
def find_a_and_b(v, roots, N):
    '''
    Input: 
     - a {0,1,..., n-1}-vector v over GF(2) where n = len(roots)
     - a list roots of integers
     - an integer N to factor
    Output:
      a pair (a,b) of integers
      such that a*a-b*b is a multiple of N
      (if v is correctly chosen)
    '''
    af = [roots[idx] for idx in v.D if v[idx] == one]
    bf = [x**2 - N for x in af]
    return (prod(af),intsqrt(prod(bf)))

## Task 5

def find_nontrivial_divisor(M,rowlistMat,roots,N):
    smallV = float("inf")
    lenM = len(M)
    zeroV = []
    for i in range(0,lenM):
        if (M[lenM-i-1]) * rowlistMat == Vec(rowlistMat.D[1],{}):
            (a,b) = find_a_and_b(M[lenM-i-1],roots,N)
            divisor = gcd(a-b,N)
            if divisor < smallV and divisor != 1 and divisor != N:
                smallV = divisor
        else:
            break
    return smallV

N = 2461799993978700679

def find_small():
    for i in range(2,N):
        if N % i == 0:
            return i



##1495279992339250451474322801862684919664000000000000
smallest_nontrivial_divisor_of_2461799993978700679 = 1230926561
