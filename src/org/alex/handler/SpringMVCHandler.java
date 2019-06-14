package org.alex.handler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.alex.entity.ActivityCitysListVo;
import org.alex.entity.ActivityJobfairsListVo;
import org.alex.entity.ActivityOfferInfosListVo;
import org.alex.entity.CompanySignup;
import org.alex.entity.Companys;
import org.alex.entity.EducationExperience;
import org.alex.entity.Industrys;
import org.alex.entity.JobIntension;
import org.alex.entity.Jobfairs;
import org.alex.entity.Logins;
import org.alex.entity.OfferInfos;
import org.alex.entity.University;
import org.alex.entity.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="handler")
public class SpringMVCHandler {
	@ResponseBody
	@RequestMapping(value="loginup")
	public List<Logins> userLogin() {
	//	System.out.println(loginid+"---"+password);
		Logins user1 = new Logins();
		user1.setLoginid("alexlantu");
		user1.setPassword("123456");
		user1.setUserid("15857163720");
		List<Logins> user = new ArrayList<Logins>();
		user.add(user1);
		return user;
	}
	
	@ResponseBody
	@RequestMapping(value="useryz")
	public String userYz(@RequestParam(value="loginid") String loginid, @RequestParam(value="password") String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		
//		设置格式
//		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
//		创建Cookie
		Cookie cookie = new Cookie("java", "myJavaData");
//		有效期，秒为单位
		cookie.setMaxAge(3600);
//		设置Cookie
		response.addCookie(cookie);
//		response.getWriter().print("cookie创建成功");
		System.out.println(loginid+"---"+password);
		return "success";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(Logins u,@RequestParam(value="loginid") String loginid, @RequestParam(value="password") String password, @RequestParam(value="checked") boolean checked, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException{
		if(u.getLoginid().equals(loginid) && u.getPassword().equals(password)) {
			if(checked == true)
				addCookie(u.getLoginid(), u.getPassword(), response, request);	
		}
		return "success";
	}
	
	public static void addCookie(String userId,String password,HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException{
        //创建cookie
        Cookie nameCookie = new Cookie(userId, password);
        nameCookie.setPath(request.getContextPath()+"/");//设置cookie路径
        //设置cookie保存的时间 单位：秒
        nameCookie.setMaxAge(7*24*60*60);
        //将cookie添加到响应
        response.addCookie(nameCookie);            
    }
	
	@ResponseBody
    @RequestMapping(value="getCookie",method=RequestMethod.POST)
	public Map<String, String> initCookie(@RequestParam(value="userId") String userId, HttpServletRequest request){
		System.out.println(userId);
		System.out.println(request.getCookies());
		Cookie[] cookie = request.getCookies();
        Map<String, String> map = new HashMap<>();
        if(cookie != null) {
	        for(Cookie c : cookie) {
	            if(c.getName().equals(userId)) {
	                String password = c.getValue();
	                map.put("userId", userId);
	                map.put("password", password);
	                return map;
	            }
	        }
        }else {
        	return map;
        }
        return null;
	}
	
	@ResponseBody
	@RequestMapping(value="findCookie",method=RequestMethod.POST)
	public String findCookie(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		boolean flag = false;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(URLDecoder.decode(cookie.getName(), "utf-8").equals("alex")) {
					System.out.println(cookie.getName());
					flag = true;
				}
			}
		}
		if(flag) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="getPersonInfo")
	public List<String> getPersonInfo() throws IOException {
//		加载mybatis配置文件（为了访问数据库）
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		相当于Connection
		SqlSession session = sessionFactory.openSession();
//		拿到SQL语句
		String st_queryUsersInfo = "org.alex.entity.loginsMapper."+"queryUsersById";
//		查询操作，由于根据ID查询所有信息，所以返回值为该查询的数据库所对应的对象
		Users users = session.selectOne(st_queryUsersInfo, "1");
		System.out.println(users);
//		创建一个列表用于装最后需要返回给前端的信息
		List<String> userlist = new ArrayList<String>();
		userlist.add(users.getUserName());
		System.out.println(users.getGender());
		String userGender = "";
		if(users.getGender() == null) {
			userGender = "";
		}else if("M".equals(users.getGender())){
			userGender = "男";
		}else {
			userGender = "女";
		}
		System.out.println(userGender);
		userlist.add(userGender);
		userlist.add(users.getBirthdate());
		String year = users.getBirthdate().substring(0, 4);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String todayDate = sdf.format(new Date()).substring(0, 4);
		String userAge = String.valueOf(Integer.parseInt(todayDate) - Integer.parseInt(year));
		userlist.add(userAge);
		userlist.add(users.getMajor());
		userlist.add(users.getDegreeLevel());
		userlist.add(users.getGraduateSchool());
		userlist.add(users.getIntention());
		userlist.add(users.getPhoneNumber());
		userlist.add(users.getEmail());
		userlist.add(users.getCity());
		return userlist;
	}
	
	
	@ResponseBody
	@RequestMapping(value="exit",method=RequestMethod.POST)
	public String exit(HttpServletRequest request, HttpServletResponse response) {
		boolean flag = false;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
				flag = true;
			}
		}
		if(flag) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="getUniversityInfo")
	public List<University> getUniversityInfo() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryUniversity = "org.alex.entity.universityMapper."+"queryUniversity";
		List<University> universityList = session.selectList(st_queryUniversity);
		for(int i=0;i<universityList.size();i++) {
			System.out.println(universityList.get(i).getName()+"---"+universityList.get(i).getCity());
		}
		
		return universityList;
	}
	
	@ResponseBody
	@RequestMapping(value="addLoginsInfo")
	public String addLoginsInfo(@RequestParam(value="loginid") String loginid, @RequestParam(value="phoneNum") String phoneNum, @RequestParam(value="email") String email, @RequestParam(value="password") String password) throws IOException {
		boolean flag = false;
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryUserid = "org.alex.entity.loginsMapper."+"queryUserid";
		Users user = session.selectOne(st_queryUserid, phoneNum);
		String st_queryLoginsById = "org.alex.entity.loginsMapper."+"queryLoginsById";
		Logins loginx = session.selectOne(st_queryLoginsById, loginid);
		if(user == null) {
			String st_addPartUsers = "org.alex.entity.loginsMapper."+"addPartUsers";
			Users userx = new Users();
			userx.setUserID(phoneNum);
			userx.setUserName(phoneNum);
			userx.setPhoneNumber(phoneNum);
			userx.setEmail(email);
			session.insert(st_addPartUsers, userx);
			session.commit();
			System.out.println("users表中没有数据");
			if(loginx == null) {
				String st_addloginsinfo = "org.alex.entity.loginsMapper."+"loginsInsert";
				Logins login = new Logins();
				login.setLoginid(loginid);
				login.setPassword(password);
				login.setUserid(phoneNum);
				session.insert(st_addloginsinfo, login);
				session.commit();
				flag = true;
				System.out.println("现在有数据了");
			}else {
				System.out.println("users表添加数据成功，logins表数据已经存在");
				flag = false;
			}
		}else {
			if(loginx == null) {
				String st_addloginsinfo = "org.alex.entity.loginsMapper."+"loginsInsert";
				Logins login = new Logins();
				login.setLoginid(loginid);
				login.setPassword(password);
				login.setUserid(phoneNum);
				session.insert(st_addloginsinfo, login);
				session.commit();
				flag = true;
				System.out.println("现在有数据了");
			}else {
				System.out.println("users表和logins表中数据已经存在");
				flag = false;
			}
		}
		session.close();
		System.out.println("执行完毕");
		if(flag) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="addPersonInfo")
	public String addPersonInfo(@RequestParam(value="userid") String userid, @RequestParam(value="name") String name, @RequestParam(value="gender") String gender, @RequestParam(value="birthdate") String birthdate, @RequestParam(value="city") String city, @RequestParam(value="major") String major, @RequestParam(value="degreelevel") String degreelevel, @RequestParam(value="school") String school, @RequestParam(value="phone") String phone, @RequestParam(value="email") String email) throws IOException {
		System.out.println("city是：" + city);
		boolean flag = false;
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryUserid = "org.alex.entity.loginsMapper."+"queryUserid";
		Users user = session.selectOne(st_queryUserid, userid);
		if(user != null) {
			String st_editUsers = "org.alex.entity.loginsMapper."+"editUsers";
			Users userx = new Users();
			userx.setUserID(userid);
			userx.setUserName(name);
			if(gender != null && "nv".equals(gender)) {
				gender = "F";
			}else {
				gender = "M";
			}
			userx.setGender(gender);
			birthdate = birthdate.substring(0, 10);
			System.out.println(birthdate);
			userx.setBirthdate(birthdate);
			userx.setCity(city);
			userx.setMajor(major);
			System.out.println(degreelevel);
			if("1".equals(degreelevel)) {
				degreelevel = "专科";
			}else if("2".equals(degreelevel)) {
				degreelevel = "本科";
			}else if("3".equals(degreelevel)) {
				degreelevel = "硕士研究生";
			}else if("4".equals(degreelevel)) {
				degreelevel = "博士研究生";
			}else {
				degreelevel = "其他";
			}
			System.out.println(degreelevel);
			userx.setDegreeLevel(degreelevel);
			userx.setGraduateSchool(school);
			session.update(st_editUsers, userx);
			session.commit();
			System.out.println("users表修改完成");
			flag = true;
		}else {
			String st_addUsers = "org.alex.entity.loginsMapper."+"addUsers";
			Users usera = new Users(userid, name, gender, birthdate, city, major, degreelevel, school, phone, email);
			session.insert(st_addUsers, usera);
			session.commit();
			System.out.println("users表新增一条完整记录");
			flag = true;
		}
		session.close();
		System.out.println("执行完毕");
		if(flag) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="addJobIntension")
	public String addJobIntension(@RequestParam(value="industryid") String industryid, @RequestParam(value="jobname") String jobname, @RequestParam(value="jobtype") String jobtype, @RequestParam(value="workcity") String workcity, @RequestParam(value="salarylowreq") String salarlowyreq, @RequestParam(value="salaryhighreq") String salaryhighreq,  @RequestParam(value="worktime") String worktime, @RequestParam(value="userid") String userid) throws IOException {
		boolean flag = false;
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryUserid = "org.alex.entity.loginsMapper."+"queryUserid";
		Users user = session.selectOne(st_queryUserid, userid);
		if(user != null) {
			if("fulltime".equals(jobtype)) {
				jobtype = "全职";
			}else if("parttime".equals(jobtype)) {
				jobtype = "兼职";
			}else {
				jobtype = "实习";
			}
			if("1".equals(worktime)) {
				worktime = "立即到岗";
			}else if("2".equals(worktime)) {
				worktime = "1周之内";
			}else if("3".equals(worktime)) {
				worktime = "1月之内";
			}else {
				worktime = "其他";
			}
			String salaryreq = salarlowyreq + "-" + salaryhighreq;
			String st_addjobintension = "org.alex.entity.loginsMapper."+"addJobIntension";
//			JobIntension jobintension = new JobIntension(industryid, jobname, jobtype, workcity, salaryreq, worktime, userid);
			JobIntension jobintension = new JobIntension();
			jobintension.setIndustryID(industryid);
			jobintension.setJobName(jobname);
			jobintension.setJobType(jobtype);
			jobintension.setWorkplaceHope(workcity);
			jobintension.setSalaryReq(salaryreq);
			jobintension.setWorkingTime(worktime);
			jobintension.setUserID(userid);
			System.out.println(jobintension.getIndustryID());
			session.insert(st_addjobintension, jobintension);
			session.commit();
			System.out.println("jobintension表新增一条记录");
			flag = true;
		}else {
			flag = false;
			System.out.println("users表中不存在该用户，请先在主表users表中增加用户");
		}
		session.close();
		System.out.println("执行完毕");
		if(flag = true) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="addEducationExperience")
	public String addEducationExperience(@RequestParam(value="schoolname") String schoolname, @RequestParam(value="rxtime") String rxtime, @RequestParam(value="bytime") String bytime, @RequestParam(value="degreelevel") String degreelevel, @RequestParam(value="major") String major, @RequestParam(value="userid") String userid) throws IOException {
		boolean flag = false;
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryUserid = "org.alex.entity.loginsMapper."+"queryUserid";
		Users user = session.selectOne(st_queryUserid, userid);
		if(user != null) {
			rxtime = rxtime.substring(0, 10);
			bytime = bytime.substring(0, 10);
			if("1".equals(degreelevel)) {
				degreelevel = "专科";
			}else if("2".equals(degreelevel)) {
				degreelevel = "本科";
			}else if("3".equals(degreelevel)) {
				degreelevel = "硕士研究生";
			}else if("4".equals(degreelevel)){
				degreelevel = "博士研究生";
			}else {
				degreelevel = "其他";
			}
			String st_addeducationexperience = "org.alex.entity.loginsMapper."+"addEducationExperience";
			EducationExperience ee = new EducationExperience(schoolname, rxtime, bytime, degreelevel, major, userid);
			session.insert(st_addeducationexperience, ee);
			session.commit();
			System.out.println("EducationExperience表新增一条记录");
			flag = true;
		}else {
			flag = false;
			System.out.println("users表中不存在该用户，请先在主表users表中增加用户");
		}
		session.close();
		System.out.println("执行完毕");
		if(flag = true) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="getCompanyInfo")
	public List<Companys> getCompanyInfo() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryCompanyInfo = "org.alex.entity.loginsMapper."+"queryCompanyInfo";
		List<Companys> companysInfo= session.selectList(st_queryCompanyInfo);
		return companysInfo;
	}
	
	@ResponseBody
	@RequestMapping(value="getOffersInfo")
	public List<ActivityOfferInfosListVo> getPartOffersInfo() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryPartOffersInfo = "org.alex.entity.loginsMapper." + "queryPartOffersInfo";
		List<ActivityOfferInfosListVo> partofferinfos = session.selectList(st_queryPartOffersInfo);
		String st_addSalaryAbout = "org.alex.entity.loginsMapper." + "addSalaryAbout";
		for(int i=0;i<partofferinfos.size();i++) {
			if("y".equals(partofferinfos.get(i).getIfFulltime())) {
				partofferinfos.get(i).setIfFulltime("全职");
			}else {
				partofferinfos.get(i).setIfFulltime("不是全职");
			}			
		}
		String reqex = "(\\d+)[\\.]?(\\d+)?K-(\\d+)[\\.]?(\\d+)?K";
		Pattern p = Pattern.compile(reqex);
		for(int j=0;j<partofferinfos.size();j++) {
//			System.out.println(partofferinfos.get(j).getSalary());
			Matcher m = p.matcher(partofferinfos.get(j).getSalary());
			if(m.matches()) {
//				System.out.println("匹配");
				String[] strArray = partofferinfos.get(j).getSalary().split("-");
				String lows = strArray[0].replace("K", "");
				String highs = strArray[1].replace("K", "");
				ActivityOfferInfosListVo oi = new ActivityOfferInfosListVo();
				oi.setSalaryLow(strArray[0]);
				oi.setSalaryHigh(strArray[1]);
				oi.setCompanyID(partofferinfos.get(j).getCompanyID());
				oi.setJobID(partofferinfos.get(j).getJobID());
				session.update(st_addSalaryAbout,  oi);
				session.commit();
				try {
					float lows_int = Float.parseFloat(lows);
					float highs_int = Float.parseFloat(highs);
					float salaryAvg = (lows_int + highs_int) / 2;
					String savg = String.valueOf(salaryAvg) + "K";
					partofferinfos.get(j).setSalary(savg);
				}catch(NumberFormatException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("不匹配");
			}
		}
//		System.out.println(partofferinfos);
		return partofferinfos;
	}
	
//	查询行业信息并返回
	@ResponseBody
	@RequestMapping(value="getIndustrys")
	public List<Industrys> getIndustrys() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryIndustrys = "org.alex.entity.loginsMapper." + "queryIndustrys";
		List<Industrys> industrys = session.selectList(st_queryIndustrys);
		System.out.println(industrys);
		return industrys;
	}
	
//	查询学校发布招聘会信息并返回给前端
	@ResponseBody
	@RequestMapping(value="getJobfairs")
	public List<ActivityJobfairsListVo> getJobfairs() throws IOException{
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryJobfairs = "org.alex.entity.loginsMapper." + "queryJobfairs";
		List<ActivityJobfairsListVo> jobfairs = session.selectList(st_queryJobfairs);
		System.out.println(jobfairs);
		return jobfairs;
	}
	
//	接收前端传来的表单数据，在企业报名表中新增一条记录
	@ResponseBody
	@RequestMapping(value="addCompanySignup")
	public String addCompanySignup(@RequestParam(value="sid") int sid, @RequestParam(value="companyName") String companyName, @RequestParam(value="companyField") String companyField, @RequestParam(value="companyType") String companyType, @RequestParam(value="companySize") String companySize, @RequestParam(value="homepage") String homepage, @RequestParam(value="contact") String contact, @RequestParam(value="phone") String phone, @RequestParam(value="email") String email, @RequestParam(value="wechat") String wechat, @RequestParam(value="qq") String qq, @RequestParam(value="jobinfodetails") String jobinfodetails, @RequestParam(value="recruitmentfilepath") String recruitmentfilepath) throws IOException {
		boolean flag = false;
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
//		查询企业信息是否存在
		String st_queryCompanyID = "org.alex.entity.loginsMapper." + "queryCompanyID";
		Companys companys = session.selectOne(st_queryCompanyID, companyName);
//		查询学校信息是否存在
		String st_queryUniversityByID = "org.alex.entity.loginsMapper." + "queryUniversityByID";
		University university = session.selectOne(st_queryUniversityByID, sid);
//		如果企业信息存在并且学校信息也存在，那么直接在企业报名表中增加一条数据
		if(companys != null && university != null) {
			CompanySignup csu = new CompanySignup(companys.getCompanyID(),sid,contact,phone,email,wechat,qq,jobinfodetails,recruitmentfilepath);
			String st_addCompanySignup = "org.alex.entity.loginsMapper." + "addCompanySignup";
			session.insert(st_addCompanySignup, csu);
			session.commit();
			System.out.println("企业报名表中已经增加一条数据");
			flag = true;
		}else if(companys == null) {
			String st_addCompanys = "org.alex.entity.loginsMapper." + "addCompanys";
			Companys companysx = new Companys();
			companysx.setCompanyName(companyName);
			companysx.setCompanyField(companyField);
			companysx.setCompanyType(companyType);
			companysx.setCompanySize(companySize);
			companysx.setHomepage(homepage);
			session.insert(st_addCompanys, companysx);
			session.commit();
			System.out.println("已在企业表中增加数据，请重新提交表单");
			flag = false;
		}
		session.close();
		if(flag = true) {
			return "success";
		}else {
			return "fail";
		}
	}
	
//	查询省份名称拼音
	@ResponseBody
	@RequestMapping(value="getProvinceNamePinyin")
	public String getProvinceNamePinyin(@RequestParam(value="provinceName") String pname) throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_querypinyin = "org.alex.entity.loginsMapper." + "queryProvinceNamePinyin";
		if(pname != null) {
			String pinyin = session.selectOne(st_querypinyin, pname);
			return pinyin;
		}else {
			System.out.println("参数为空");
			return "fail";
		}
		
	}
	
//	查询省份ID
	@ResponseBody
	@RequestMapping(value="getProvinceID")
	public String getProvinceID(@RequestParam(value="provinceName") String pname) throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryID = "org.alex.entity.loginsMapper." + "queryProvinceID";
		if(pname != null) {
			String provinceID = session.selectOne(st_queryID, pname);
			return provinceID;
		}else {
			System.out.println("参数为空");
			return "fail";
		}
		
	}
	
//	查询企业ID
	@ResponseBody
	@RequestMapping(value="getCompanyID")
	public int getCompanyID(@RequestParam(value="companyName") String cname) throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryID = "org.alex.entity.loginsMapper." + "querycid";
		if(cname != null) {
			int companyID = session.selectOne(st_queryID, cname);
			return companyID;
		}else {
			System.out.println("参数为空");
			return -1;
		}
		
	}
	
	
}
