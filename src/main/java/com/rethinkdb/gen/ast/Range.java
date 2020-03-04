// Autogenerated by metajava.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../../templates/AstSubclass.java

package com.rethinkdb.gen.ast;

import com.rethinkdb.gen.proto.TermType;
import com.rethinkdb.gen.exc.ReqlDriverError;
import com.rethinkdb.model.Arguments;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.ast.ReqlAst;

public class Range extends ReqlExpr {

    public Range(Object arg) {
        this(new Arguments(arg), null);
    }
    public Range(Arguments args){
        this(args, null);
    }
    public Range(Arguments args, OptArgs optargs) {
        super(TermType.RANGE, args, optargs);
    }

}
