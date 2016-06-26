# -*- coding: UTF-8 -*- 
# File Name: Vector.py
# Author: Sam
# mail: samyunwei@163.com
# Created Time: 六  6/25 18:09:18 2016
#########################################################################
#!/usr/bin/env python
from copy import deepcopy
class Vector(list):
    __doc__ = 'the model for Vector'
    __version__ = '0.1'

    def getSize(self):
        return len(self)

    def getElements(self):
        'return the deepcopy not &'
        return [deepcopy(x) for x in self]
    
    def removebyIndex(self,low,high):
        'remove from high to low'
        del self[low:high]

    def find(self,value,low = 0,high = None):
        'find theobject if not find return -1'
        try:
            if high is None:
                high = len(self)
            return self.index(value,low,high)
        except ValueError,e:
            return low - 1;
    
    def deduplicate(self):
        'delet the deduplicate object in list'
        count = len(self)
        i = 0
        while(i < count):
            if(self.find(self[i],0,i) > 0):
                self.pop(i)
            i += 1;

    def traverse(self,thefunc):
        'use func change every objecy '
        count = len(self)
        for i in range(count):
            self[i] = thefunc(self[i])

if __name__ == '__main__':
    '''
    thetest = Vector([x for x in range(6)])
    print thetest.getSize()
    print len(thetest)
    print thetest.getElements()
    thetest.removebyIndex(0,3)
    print thetest
    print thetest.find(7)
    '''
    thetest = Vector([1,2,4,4])
    print thetest
    thetest.deduplicate()
    print thetest
    thetest.traverse(lambda x:x+1)
    print thetest
