package de.struktuhr.demo;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
public class EnvironmentInfo {

    private final Environment environment;

    public EnvironmentInfo(Environment environment) {
        this.environment = environment;
    }

    public String getWorkerName() {
        String envHostName = environment.getProperty("HOSTNAME");
        return envHostName != null && !envHostName.isEmpty()
                ? envHostName
                : getHostname() + ":" + getPort();
    }

    private String getPort() {
        return environment.getProperty("server.port", "8080");
    }

    private String getHostname() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch(Exception e) {
            return "localhost";
        }
    }
}
