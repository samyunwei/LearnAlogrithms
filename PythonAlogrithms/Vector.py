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
    


if __name__ == '__main__':
    thetest = Vector([x for x in range(6)])
    print thetest.getSize()
    print len(thetest)
    print thetest.getElements()
