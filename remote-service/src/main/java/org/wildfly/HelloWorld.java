package org.wildfly;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {

    String returnSmth();
}
