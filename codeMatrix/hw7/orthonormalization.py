from orthogonalization import *
from math import sqrt
from vec import Vec
from mat import *
from matutil import coldict2mat,mat2coldict

def orthonormalize(L):
    '''
    Input: a list L of linearly independent Vecs
    Output: A list T of orthonormal Vecs such that for all i in [1, len(L)],
            Span L[:i] == Span T[:i]
    '''
    vlist = orthogonalize(L)
    return [1/sqrt(v*v) * v for v in vlist]



def adjust(v,mul):
    return Vec(v.D,{key:v[key]*mul[key] for key in v.D})


def aug_orthonormalize(L):
    '''
    Input:
        - L: a list of Vecs
    Output:
        - A pair Qlist, Rlist such that:
            * coldict2mat(L) == coldict2mat(Qlist) * coldict2mat(Rlist)
            * Qlist = orthonormalize(L)
    '''
    Qlist = orthonormalize(L)
    Rlist = mat2coldict(transpose(coldict2mat(Qlist)) * coldict2mat(L))
    newRlist = [Rlist[k] for k in Rlist]
    return Qlist,newRlist
