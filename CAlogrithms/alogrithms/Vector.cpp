//
//  Vector.cpp
//  CAlogrithms
//
//  Created by sam on 16/6/28.
//  Copyright © 2016年 sam. All rights reserved.
//

#include "Vector.h"


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

//重载[]运算符方便访问
template <typename T>
T& Vector<T>::operator[](Rank r)const
{
    return m_elem[r];
}


//交换方便日后操作
template <typename T>
void Vector<T>::swap(T& T1,T& T2)
{
    T* temp = &T1;
    &T1 = &T2;
    &T2 = temp;
}


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


//缩容至25% - 50%,使复杂大量算法提高效率
template<typename T>
void Vector<T>::shrink(void)
{
    if(m_capacity < DEFAULT_CAPACITY << 1)
    {
        return;
    }
    
    if(m_size << 2 > m_capacity)
    {
        return;
    }
    
    T* oldElem = m_elem;
    m_elem =  new T[m_capacity >>= 1];
    for(int i = 0;i <m_size;i++)
    {
        m_elem[i] = oldElem[i];
    }
    delete [] oldElem;
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

//置乱一个区间
template<typename T>
void Vector<T>::unsort(Rank low,Rank high)
{
    T* V = m_elem + low;
    for(Rank i = high - low; i>0 ;i--)
    {
        swap(V[i-1],V[rand() % i]);
    }
}

//返回查找到的元素的置最大者若无值则返回-1
template<typename T>
Rank Vector<T>::find(T const&e,Rank low,Rank high)const
{
    while((low < high)&& (e != m_elem[high]))
    {
        high--;
    }
    return high;
}