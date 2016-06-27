//
//  Vector.cpp
//  CAlogrithms
//
//  Created by sam on 16/6/28.
//  Copyright © 2016年 sam. All rights reserved.
//

#include "Vector.h"

//扩容两倍
template<typename T>
void Vector<T>::expand(void)
{
    if(m_size < m_capacity)
    {
        return;
    }
    if(m_capacity < DEFAULT_CAPACITY)
    {
        m_capacity = DEFAULT_CAPACITY;
    }
    
    T* oldElem = m_elem;
    m_elem = new T[m_capacity << 2];
    for(int i = 0;i<m_size;i++)
    {
        m_elem[i] = oldElem[i];
    }
    delete []oldElem;
}


//构造函数
template<typename T>
Vector<T>::Vector(int c ,int s ,T v )
{
    m_elem = new T[c];
    m_size = 0;
    while(s < m_size)
    {
        m_elem[m_size] = v;
        m_size++;
    }
    
}

//析构函数释放空间
template<typename T>
Vector<T>::~Vector()
{
    delete []m_elem;
}


//重载＝运算符方便比较
template<typename T>
Vector<T>& Vector<T>::operator=(Vector<T>const& V)
{
    if(this == &V)
    {
        return *this;
    }
    if(m_elem)
    {
        delete []m_elem;
    }
    copyfrom(V.m_elem,0, V.m_size);
    return *this;
}


//从另一Vector拷贝
template<typename T>
void Vector<T>::copyfrom(T const *A,Rank low,Rank high)
{
    m_elem = new T[m_capacity = 2 * (high - low)];
    m_size = 0;
    while(low < high)
    {
        m_elem[m_size++] = A[low++];
    }
}