// Autogenerated by metajava.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../../templates/Exception.java
package com.rethinkdb.gen.exc;

import org.jetbrains.annotations.Nullable;
import com.rethinkdb.ast.ReqlAst;
import com.rethinkdb.model.Backtrace;

public class ReqlAvailabilityError extends ReqlRuntimeError {

    @Nullable Backtrace backtrace;
    @Nullable ReqlAst term;

    public ReqlAvailabilityError() {
    }

    public ReqlAvailabilityError(String message) {
        super(message);
    }

    public ReqlAvailabilityError(String format, Object... args) {
        super(String.format(format, args));
    }

    public ReqlAvailabilityError(String message, Throwable cause) {
        super(message, cause);
    }

    public ReqlAvailabilityError(Throwable cause) {
        super(cause);
    }

    public ReqlAvailabilityError(String msg, ReqlAst term, Backtrace bt) {
        super(msg);
        this.backtrace = bt;
        this.term = term;
    }

    public @Nullable Backtrace getBacktrace() {
        return backtrace;
    }

    public ReqlAvailabilityError setBacktrace(Backtrace backtrace) {
        this.backtrace = backtrace;
        return this;
    }

    public @Nullable ReqlAst getTerm() {
        return this.term;
    }

    public ReqlAvailabilityError setTerm(ReqlAst term) {
        this.term = term;
        return this;
    }
}
