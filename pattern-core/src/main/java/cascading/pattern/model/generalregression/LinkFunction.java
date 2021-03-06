/*
 * Copyright (c) 2007-2015 Concurrent, Inc. All Rights Reserved.
 *
 * Project and contact information: http://www.cascading.org/
 *
 * This file is part of the Cascading project.
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

package cascading.pattern.model.generalregression;

/** Enum for the LinkFunction in GLM */
public enum LinkFunction
  {
    NONE( "none" )
      {
      public double calculate( double value )
        {
        return value;
        }
      },

    LOGIT( "logit" )
      {
      public double calculate( double value )
        {
        return 1.0 / ( 1.0 + Math.exp( -value ) );
        }
      },

    CLOGLOG( "cloglog" )
      {
      public double calculate( double value )
        {
        return 1.0 - Math.exp( -Math.exp( value ) );
        }
      },

    LOGLOG( "loglog" )
      {
      public double calculate( double value )
        {
        return Math.exp( -Math.exp( -value ) );
        }
      },

    CAUCHIT( "cauchit" )
      {
      public double calculate( double value )
        {
        return 0.5 + 1.0 / Math.PI * Math.atan( value );
        }
      };

  public String function;

  private LinkFunction( String function )
    {
    this.function = function;
    }

  /**
   * Returns the corresponding LinkFunction
   *
   * @param functionName String
   * @return LinkFunction
   */
  public static LinkFunction getFunction( String functionName )
    {

    for( LinkFunction lf : values() )
      if( lf.function.matches( functionName ) )
        return lf;

    return LinkFunction.NONE;
    }

  public abstract double calculate( double value );
  }
