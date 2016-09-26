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
#include <stdlib.h>
template<typename T > class Vector
{
protected:
    Rank m_size; //向量大小
    int m_capacity;//向量容量
    T* m_elem;//向量指针
public:
    //构造函数
    Vector(int c = DEFAULT_CAPACITY,int s = 0,T v = 0);
    
    //
    ~Vector();
    
    //运算符重载
    Vector<T> & operator=(Vector<T>const&);
    T& operator[](Rank r) const;
    
    //交换
    void swap(T& T1,T& T2);
    //扩容
    void expand(void);//expand double size;
    //缩容
    void shrink(void);
    //拷贝
    void copyfrom(T const *A,Rank low,Rank high);
    //置乱
    void unsort(Rank low,Rank high);
    //无序向量查找
    Rank find(T const&e,Rank low,Rank high)const;

    
};
#endif /* Vector_h */
