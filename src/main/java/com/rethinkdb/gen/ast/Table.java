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

public class Table extends ReqlExpr {

    public Table(Object arg) {
        this(new Arguments(arg), null);
    }
    public Table(Arguments args){
        this(args, null);
    }
    public Table(Arguments args, OptArgs optargs) {
        super(TermType.TABLE, args, optargs);
    }
    public Table optArg(String optname, Object value) {
        OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
        return new Table(args, newOptargs);
    }
    public Table optArg(String optname, ReqlFunction0 value) {
        OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
        return new Table(args, newOptargs);
    }
    public Table optArg(String optname, ReqlFunction1 value) {
        OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
        return new Table(args, newOptargs);
    }
    public Table optArg(String optname, ReqlFunction2 value) {
        OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
        return new Table(args, newOptargs);
    }
    public Table optArg(String optname, ReqlFunction3 value) {
        OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
        return new Table(args, newOptargs);
    }
    public Table optArg(String optname, ReqlFunction4 value) {
        OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
        return new Table(args, newOptargs);
    }

    public Get get(Object expr) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        return new Get(arguments);
    }
    public GetAll getAll(Object... exprs) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAddAll(exprs);
        return new GetAll(arguments);
    }
    public Insert insert(Object expr) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        return new Insert(arguments);
    }
    public Config config() {
        Arguments arguments = new Arguments(this);
        return new Config(arguments);
    }
    public Status status() {
        Arguments arguments = new Arguments(this);
        return new Status(arguments);
    }
    public Wait wait_() {
        Arguments arguments = new Arguments(this);
        return new Wait(arguments);
    }
    public Reconfigure reconfigure() {
        Arguments arguments = new Arguments(this);
        return new Reconfigure(arguments);
    }
    public Rebalance rebalance() {
        Arguments arguments = new Arguments(this);
        return new Rebalance(arguments);
    }
    public Sync sync() {
        Arguments arguments = new Arguments(this);
        return new Sync(arguments);
    }
    public Grant grant(Object expr, Object exprA) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        arguments.coerceAndAdd(exprA);
        return new Grant(arguments);
    }
    public IndexCreate indexCreate(Object expr) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        return new IndexCreate(arguments);
    }
    public IndexCreate indexCreate(Object expr, Javascript js) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        arguments.coerceAndAdd(js);
        return new IndexCreate(arguments);
    }
    public IndexCreate indexCreate(Object expr, Object exprA) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        arguments.coerceAndAdd(exprA);
        return new IndexCreate(arguments);
    }
    public IndexCreate indexCreate(Object expr, ReqlFunction0 func0) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        arguments.coerceAndAdd(func0);
        return new IndexCreate(arguments);
    }
    public IndexCreate indexCreate(Object expr, ReqlFunction1 func1) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        arguments.coerceAndAdd(func1);
        return new IndexCreate(arguments);
    }
    public IndexDrop indexDrop(Object expr) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        return new IndexDrop(arguments);
    }
    public IndexList indexList() {
        Arguments arguments = new Arguments(this);
        return new IndexList(arguments);
    }
    public IndexStatus indexStatus(Object... exprs) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAddAll(exprs);
        return new IndexStatus(arguments);
    }
    public IndexWait indexWait(Object... exprs) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAddAll(exprs);
        return new IndexWait(arguments);
    }
    public IndexRename indexRename(Object expr, Object exprA) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        arguments.coerceAndAdd(exprA);
        return new IndexRename(arguments);
    }
    public GetIntersecting getIntersecting(Object expr) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        return new GetIntersecting(arguments);
    }
    public GetNearest getNearest(Object expr) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        return new GetNearest(arguments);
    }
    public SetWriteHook setWriteHook(Javascript js) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(js);
        return new SetWriteHook(arguments);
    }
    public SetWriteHook setWriteHook(ReqlFunction3 func3) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(func3);
        return new SetWriteHook(arguments);
    }
    public GetWriteHook getWriteHook() {
        Arguments arguments = new Arguments(this);
        return new GetWriteHook(arguments);
    }
}
