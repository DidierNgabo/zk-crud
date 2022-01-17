package com.work.diddy.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;

import com.work.diddy.domain.User;
import com.work.diddy.ui.service.ServiceImp;

public class UserViewModel {
	
	public User user=new User();
	
	@Wire
	private Window win;
	
	
	private List<User> users = new ArrayList<>();
	private ServiceImp service= new ServiceImp();

	@Init
	public void init() {
		users = service.findAll();	
	}
	
	@Command
	@NotifyChange("users")
	public void saveUser() {
		service.addUser(user);
		users = service.findAll();
		
	}
	
	    @Command
	    @NotifyChange("users")
		public void deleteUser(@BindingParam() User usr) {
				service.delete(usr);
				Clients.showNotification("Deleted successfully",Clients.NOTIFICATION_TYPE_INFO,null, "top_center", 5000,
						true);
				users = service.findAll();
		}

	@Command
	public void openModal() {
		 win = (Window)Executions.createComponents(
                "form.zul", null, null);
		win.doModal();
	}
	
	@Command
	public void closeModal() {
		System.out.println("in here");
		 win.detach();
	}
	
	public List<User> getUsers() {
		return users;
	}

	public User getUser() {
		return user;
	}
	
	

	
	
	
	
}
