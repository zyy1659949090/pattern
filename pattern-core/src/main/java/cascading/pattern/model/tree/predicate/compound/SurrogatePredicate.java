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

package cascading.pattern.model.tree.predicate.compound;

import java.util.Iterator;
import java.util.List;

import cascading.pattern.model.tree.predicate.Predicate;

/**
 * Class SurrogatePredicate returns the result of the first child predicate
 * that as non null or not missing value. This is similar to a if then else statement.
 */
public class SurrogatePredicate extends CompoundPredicate
  {
  public SurrogatePredicate( List<Predicate> predicates )
    {
    super( predicates );
    }

  public SurrogatePredicate( Predicate... predicates )
    {
    super( predicates );
    }

  @Override
  public Boolean evaluate( Iterator<Boolean> results )
    {
    while( results.hasNext() )
      {
      Boolean result = results.next();

      if( result != null )
        return result;
      }

    return null;
    }
  }
