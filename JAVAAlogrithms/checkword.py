# -*- coding: UTF-8 -*- 
# File Name: checkword.py
# Author: Sam
# mail: samyunwei@163.com
# Created Time: 三  6/29 20:59:43 2016
#########################################################################
#!/usr/bin/env python
import os

def GetFileByType(therootPath,thefileType):
    res = []
    for root,dirs,files in os.walk(therootPath):
        for eachfile in files:
            if thefileType in eachfile:
                res.append(os.path.join(root,eachfile))
    return res
    
    
def CheckFile(theFile,theWords):
    try:
        res = []
        with open(theFile,'r') as f:
            row = 0
            for eachline in f:
                row += 1
                eachline = eachline.strip()
                for eachword in theWords:
                    if (eachline.find(eachword) != -1):
                        tempres = str('%s find %s in %d line ' % (eachfile,eachword,row))
                        res.append(tempres)
        return res
    except IOError,e:
        print e
        return None


if __name__ == '__main__':
    files = GetFileByType('./','.java')
    words = ['testword']
    res = []
    for eachfile in files:
        fres = CheckFile(eachfile,words)
        if fres and len(fres):
            res.extend(fres)

    for eachline in res:
        print eachline
