package com.go2plus.core.extra.web.taglib;

import java.util.Iterator;

/**
 * <p>提供el中可以使用的一些函数
 * <p>User: mtwu
 * <p>Date: 2015-12-12
 * <p>Version: 1.0
 */
public class EsFunctions {
  
  public static boolean in(Iterable iterable, Object obj) {
    if(iterable == null) {
        return false;
    }
    Iterator iterator = iterable.iterator();

    while(iterator.hasNext()) {
        if(iterator.next().equals(obj)) {
            return true;
        }
    }
    return false;
}
}
