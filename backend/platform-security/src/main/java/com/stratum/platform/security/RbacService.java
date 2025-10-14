package com.stratum.platform.security;

import java.util.Map;
import java.util.Set;

/**
 * Simple in-memory RBAC registry used for documentation examples.
 */
public class RbacService {

    private final Map<String, Set<String>> rolePermissions;

    public RbacService(Map<String, Set<String>> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    public boolean isAllowed(String role, String permission) {
        return rolePermissions.getOrDefault(role, Set.of()).contains(permission);
    }
}
