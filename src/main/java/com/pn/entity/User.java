package com.pn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * user_info表的实体类:
 */
@Data
@ToString
public class User {

	private int userId;//用户id
	@Pattern(regexp = "^[0-9a-zA-Z]{4,20}$",message = "账号输入错误")
	private String userCode;//账号
	@Pattern(regexp = "^[\\u4e00-\\u9fff\\w]{1,20}$",message = "昵称输入错误")
	private String userName;//昵称
	@Pattern(regexp = "^\\w{4,18}$",message = "密码输入错误")
	private String userPwd;//用户密码

	private String userType;//用户类型

	private String userState;//用户状态

	private String isDelete;//删除状态
	private int createBy;//创建人id

	//返回前端时,自动将Date转换成指定格式的json字符串
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;//创建时间

	private int updateBy;//修改人id

	private Date updateTime;//修改时间

	private String getCode;//追加的属性--创建人

	public User() {

	}

	public User(int userId, String userCode, String userName, String userPwd,
			String userType, String userState, String isDelete, int createBy,
			Date createTime, int updateBy, Date updateTime) {
		this.userId = userId;
		this.userCode = userCode;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
		this.userState = userState;
		this.isDelete = isDelete;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
	}
}
