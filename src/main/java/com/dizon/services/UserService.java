package com.dizon.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

//import com.dizon.datasource.UserRepository;
import com.dizon.models.User;

@Service
public class UserService {

	//@Autowired
	//UserRepository userRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public User getUser(long id) {

		try {
			String sql = "select * from Users where Id = ?";
			Map<String, Object> result = jdbcTemplate.queryForMap(sql, new Object[] { id });
			User usr = new User();
			usr.setId((int)result.get("Id"));
			usr.setFirstName((String)result.get("Firstname"));
			usr.setLastName((String)result.get("Lastname"));
			usr.setEmail((String)result.get("Email"));
			return usr;
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	
	public long updateUser(User usr)
	{
		String sql = "update Users set Firstname = ?, Lastname = ?, Email = ? where Id = ?";
		jdbcTemplate.update(sql, new Object[] { usr.getFirstname(), usr.getLastName(), usr.getEmail(), usr.getId() });
		
		return usr.getId();
	}
	
	/*
	public Page<User> getPage(int _PageNo, int _PageSize, String _Email) {

		int pNo = _PageNo - 1;
		if (pNo < 0)
			pNo = 0;
		Pageable paging = PageRequest.of(pNo, _PageSize);
		Page<User> pagedResult = null;
		if (Strings.isEmpty(_Email)) {
			pagedResult = userRepository.findall(paging);
		} else {
			pagedResult = userRepository.findByEmail(paging, _Email);
		}

		return pagedResult;
	}
	*/
	
}
