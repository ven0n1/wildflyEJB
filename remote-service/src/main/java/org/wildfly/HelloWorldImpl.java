package org.wildfly;

import javax.ejb.Stateless;

@Stateless(name = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String returnSmth() {
        return "from remote another version. Changed";
    }
}
