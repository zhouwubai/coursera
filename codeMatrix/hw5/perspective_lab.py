from image_mat_util import *
from matutil import *

from mat import Mat
from vec import Vec

from solver import solve

## Task 1
def move2board(v): 
    '''
    Input:
        - v: a vector with domain {'y1','y2','y3'}, the coordinate representation of a point q.
    Output:
        - A {'y1','y2','y3'}-vector z, the coordinate representation
          in whiteboard coordinates of the point p such that the line through the 
          origin and q intersects the whiteboard plane at p.
    '''
    return Vec({'y1','y2','y3'}, {key:v[key]/v['y3'] for key in v.D})

## Task 2
def make_equations(x1, x2, w1, w2): 
    '''
    Input:
        - x1 & x2: photo coordinates of a point on the board
        - y1 & y2: whiteboard coordinates of a point on the board
    Output:
        - List [u,v] where u*h = 0 and v*h = 0
    '''
    domain = {(a, b) for a in {'y1', 'y2', 'y3'} for b in {'x1', 'x2', 'x3'}}
    u = Vec(domain, {})
    v = Vec(domain, {})
    u[('y3','x1')] = w1 * x1
    u[('y3','x2')] = w1 * x2
    u[('y3','x3')] = w1
    u[('y1','x1')] = -x1
    u[('y1','x2')] = -x2
    u[('y1','x3')] = -1
    v[('y3','x1')] = w2 * x1
    v[('y3','x2')] = w2 * x2
    v[('y3','x3')] = w2
    v[('y2','x1')] = -x1
    v[('y2','x2')] = -x2
    v[('y2','x3')] = -1
    return [u, v]

domain = {(a, b) for a in {'y1', 'y2', 'y3'} for b in {'x1', 'x2', 'x3'}}
ninthV = Vec(domain,{('y1','x1'):1})

## Task 3
a1 = make_equations(358, 36, 0, 0)
a2 = make_equations(329, 597, 0, 1)
a3 = make_equations(592, 157, 1, 0)
a4 = make_equations(580, 483, 1, 1)
list = []
list.extend(a1)
list.extend(a2)
list.extend(a3)
list.extend(a4)
list.append(ninthV)
b = Vec({0,1,2,3,4,5,6,7,8},{8:1})
sol = solve(rowdict2mat(list),b)

H = Mat(({'y1','y2','y3'},{'x1','x2','x3'}),sol.f)

## Task 4
def mat_move2board(Y):
    '''
    Input:
        - Y: Mat instance, each column of which is a 'y1', 'y2', 'y3' vector 
          giving the whiteboard coordinates of a point q.
    Output:
        - Mat instance, each column of which is the corresponding point in the
          whiteboard plane (the point of intersection with the whiteboard plane 
          of the line through the origin and q).
    '''
    return Mat(Y.D,{(row,col):Y[(row,col)]/Y[('y3',col)] for row in Y.D[0] for col in Y.D[1]})
