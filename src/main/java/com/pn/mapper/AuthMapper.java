package com.pn.mapper;

import java.util.List;
import com.pn.entity.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper

public interface AuthMapper {

	//根据用户id查询用户所有权限(菜单)的方法
	public List<Auth> findAllAuth(int userId);

	//查询所有状态正常的权限(菜单)的方法
	public List<Auth> getAllAuth();

	//根据角色id删除给角色已分配的所有权限(菜单)
	public int delAuthByRoleId(Integer roleId);

	//添加角色权限(菜单)关系的方法
	public void insertRoleAuth(Integer roleId, Integer authId);
	// 根据角色id查询绑定该角色id的用户
	@Select("select user_id from user_role where role_id = #{roleId}")
	public List<Integer> getRoleUser(Integer roleId);

}
