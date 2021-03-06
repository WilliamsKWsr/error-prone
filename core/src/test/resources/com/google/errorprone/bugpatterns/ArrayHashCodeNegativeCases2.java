/*
 * Copyright 2014 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.errorprone.bugpatterns;

import java.util.Objects;

/**
 * Java 7 specific tests
 * 
 * @author eaftan@google.com (Eddie Aftandilian)
 */
public class ArrayHashCodeNegativeCases2 {
  
  private Object[] objArray = {1, 2, 3};
  private String[] stringArray = {"1", "2", "3"};
  private int[] intArray = {1, 2, 3};
  private byte[] byteArray = {1, 2, 3};
  private Object obj = new Object();
  private String str = "foo";
    
  public void nonVaragsHashCodeOnNonArrayType() {
    int hashCode;
    hashCode = Objects.hashCode(obj);    
    hashCode = Objects.hashCode(str);
  }
  
  public void varargsHashCodeOnMoreThanOneArg() {
    int hashCode;
    hashCode = Objects.hash(objArray, intArray);
    hashCode = Objects.hash(stringArray, byteArray);
  }
  
  public void varagsHashCodeOnNonArrayType() {
    int hashCode;
    hashCode = Objects.hash(obj);
    hashCode = Objects.hash(str);
  }
  
  public void varagsHashCodeOnObjectOrStringArray() {
    int hashCode;
    hashCode = Objects.hash(objArray);  
    hashCode = Objects.hash((Object[]) stringArray);    
  }
}
