package org.alex.service;

import java.util.List;

import org.alex.entity.Permission;
import org.alex.entity.Role;

public interface PermissionService {
	
	public List<Permission> getByRole(Role role);

}
