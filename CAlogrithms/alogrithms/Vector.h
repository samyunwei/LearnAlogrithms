//
//  Vector.h
//  CAlogrithms
//
//  Created by sam on 16/6/28.
//  Copyright © 2016年 sam. All rights reserved.
//

#ifndef Vector_h
#define Vector_h

typedef int Rank;
#define DEFAULT_CAPACITY 3
#include <stdio.h>
template<typename T > class Vector
{
protected:
    Rank m_size;
    int m_capacity;
    T* m_elem;
    
    Vector(int c = DEFAULT_CAPACITY,int s = 0,T v = 0);
    ~Vector();
    Vector<T> & operator=(Vector<T>const&);
    void expand(void);//expand double size;
    void copyfrom(T const *A,Rank low,Rank high);
    
};
#endif /* Vector_h */
