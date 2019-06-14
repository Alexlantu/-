package org.alex.handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alex.entity.ActivityCitysListVo;
import org.alex.entity.Province;
import org.alex.entity.Recruitmentads;
import org.alex.entity.University;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="ResourceHandler")
public class ResourceHandler {
	
	@ResponseBody
	@RequestMapping(value="getResourceInfo",produces="text/html;charset=UTF-8")
	public String getResourceInfo(@RequestParam(value="filename") String filename) {
	      
	     String Path = "C:\\Users\\Alex\\eclipse-workspace2\\JobInfoKDS\\WebContent\\resource\\" + filename + ".json";
	     BufferedReader reader = null;
	     String laststr = "";
	     try {
	    	 FileInputStream fileInputStream = new FileInputStream(Path);
	         InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
	         reader = new BufferedReader(inputStreamReader);
	         String tempString = null;
	         while ((tempString = reader.readLine()) != null) {
	             laststr += tempString;
	          }
	         reader.close();
	     	} catch (IOException e) {
	     		e.printStackTrace();
	        } finally {
	        	if (reader != null) {
	        		try {
	        			reader.close();
	        		} catch (IOException e) {
	        			e.printStackTrace();
	                }
	           }
	       }
	       return laststr;
	   }
	
	@ResponseBody
	@RequestMapping(value="getRecruitmentads")
	public List<Recruitmentads> getRecruitmentads() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryRecruitmentads = "org.alex.entity.loginsMapper." + "queryRecruitmentads";
		List<Recruitmentads> ra = session.selectList(st_queryRecruitmentads);
		for(int i=0;i<ra.size();i++) {
			System.out.println(ra.get(i).getRecruitmentadsID() +"---"+ra.get(i).getRecruitmentadsName() + "---" + ra.get(i).getUploadDate() + "---" + ra.get(i).getFilepath());
		}
		return ra;
	}
	
	@ResponseBody
	@RequestMapping(value="downloadFile")
	public ResponseEntity<byte[]> downloadFile(HttpServletRequest request,HttpServletResponse response, @RequestParam(value="filename") String filename) throws IOException {
		System.out.println(filename);
//		filename = URLDecoder.decode(filename,"utf-8");
		System.out.println(filename);
//		String myFileName=new String(filename.getBytes("utf-8"),"iso-8859-1");
		String filepath = "C:\\Users\\Alex\\eclipse-workspace2\\JobInfoKDS\\WebContent\\resource\\file\\" + filename + ".pdf";
		System.out.println(filepath);
	    File file = new File(filepath);
	    byte[] body = null;
	    InputStream is = new FileInputStream(file);
	    body = new byte[is.available()];
	    is.read(body);
	    HttpHeaders headers = new HttpHeaders();
	    String filenamex = new String(file.getName().getBytes(), "ISO8859-1");
	    headers.add("Content-Disposition", "attchement;filename=" + filenamex);
	    HttpStatus statusCode = HttpStatus.OK;
	    ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
	    System.out.println(entity);
	    return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="getUniversity")
	public List<University> getUniversity() throws IOException{
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryUniversity = "org.alex.entity.loginsMapper." + "queryUniversity";
		List<University> university = session.selectList(st_queryUniversity);
		System.out.println(university);
		return university;
	}
	
//	得到各个省的平均薪资数据
	@ResponseBody
	@RequestMapping(value="getPartProvinceInfo")
	public List<Map> getPartProvinceInfo() throws IOException{
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryPSA = "org.alex.entity.loginsMapper." + "queryProvinceSalaryAvg";
		List<Map> ppimap = session.selectList(st_queryPSA);
		return ppimap;
	}
	
//	得到各个省不同时间的薪资数据
	@ResponseBody
	@RequestMapping(value="getProvinceTimeSalarywithargs")
	public List<Map> getProvinceTimeSalarywithargs(@RequestParam(value="timeid") String timeid) throws IOException{
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryPTS = "org.alex.entity.loginsMapper." + "queryProvinceTimeSalary";
		List<Map> ptsmap = session.selectList(st_queryPTS, timeid);
		return ptsmap;
	}
	
//	得到省下各个城市的平均薪资数据
	@ResponseBody
	@RequestMapping(value="getPartCitysInfo")
	public List<Map> getPartCitysInfo(@RequestParam(value="ProvinceID") String ProvinceID) throws IOException{
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryCSA = "org.alex.entity.loginsMapper." + "queryCitySalaryAvg";
		List<Map> pcimap = session.selectList(st_queryCSA, ProvinceID);
		return pcimap;
	}
	
	@ResponseBody
	@RequestMapping(value="getChinaIntervalSalary")
	public List<Map> getChinaIntervalSalary(@RequestParam(value="timeid") String timeid) throws IOException{
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryCIS = "org.alex.entity.loginsMapper." + "queryChinaIntervalSalary";
//		ArrayList<String> args = new ArrayList<String>();
//		args.add(pid);
//		args.add(timeid);
		List<Map> cismap = session.selectList(st_queryCIS, timeid);
		return cismap;
	}
	
//	查询不同级别城市的不同薪资区间数量，作为前端绘制热力图的数据源
	@ResponseBody
	@RequestMapping(value="getCitySalaryAvg")
	public Map getCitySalaryAvg() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_querycsa = "org.alex.entity.loginsMapper." + "queryCityInfos";
		List<ActivityCitysListVo> citysinfo = session.selectList(st_querycsa);
//		一线城市
		int isonelineandlesssix = 0;
		ArrayList<String> oalscn = new ArrayList<String>();		
		int isonelineandsixtoseven = 0;
		ArrayList<String> oastscn = new ArrayList<String>();
		int isonelineandseventoeight = 0;
		ArrayList<String> oastecn = new ArrayList<String>();
		int isonelineandeighttonine = 0;
		ArrayList<String> oaetncn = new ArrayList<String>();
		int isonelineandmorethannine = 0;
		ArrayList<String> oamtncn = new ArrayList<String>();
//		新一线城市
		int isnewonelineandls = 0;
		ArrayList<String> noalscn = new ArrayList<String>();
		int isnewonelineandsts = 0;
		ArrayList<String> noastscn = new ArrayList<String>();
		int isnewonelineandste = 0;
		ArrayList<String> noastecn = new ArrayList<String>();
		int isnewonelineandetn = 0;
		ArrayList<String> noaetncn = new ArrayList<String>();
		int isnewonelineandmtn = 0;
		ArrayList<String> noamtncn = new ArrayList<String>();
//		二线城市
		int istwolineandls = 0;
		ArrayList<String> talscn = new ArrayList<String>();
		int istwolineandsts = 0;
		ArrayList<String> tastscn = new ArrayList<String>();
		int istwolineandste = 0;
		ArrayList<String> tastecn = new ArrayList<String>();
		int istwolineandetn = 0;
		ArrayList<String> taetncn = new ArrayList<String>();
		int istwolineandmtn = 0;
		ArrayList<String> tamtncn = new ArrayList<String>();
//		三线城市
		int isthreelineandls = 0;
		ArrayList<String> thalscn = new ArrayList<String>();
		int isthreelineandsts = 0;
		ArrayList<String> thastscn = new ArrayList<String>();
		int isthreelineandste = 0;
		ArrayList<String> thastecn = new ArrayList<String>();
		int isthreelineandetn = 0;
		ArrayList<String> thaetncn = new ArrayList<String>();
		int isthreelineandmtn = 0;
		ArrayList<String> thamtncn = new ArrayList<String>();
//		四线城市
		int isfourlineandls = 0;
		ArrayList<String> falscn = new ArrayList<String>();
		int isfourlineandsts = 0;
		ArrayList<String> fastscn = new ArrayList<String>();
		int isfourlineandste = 0;
		ArrayList<String> fastecn = new ArrayList<String>();
		int isfourlineandetn = 0;
		ArrayList<String> faetncn = new ArrayList<String>();
		int isfourlineandmtn = 0;
		ArrayList<String> famtncn = new ArrayList<String>();
//		五线城市
		int isfivelineandls = 0;
		ArrayList<String> fialscn = new ArrayList<String>();
		int isfivelineandsts = 0;
		ArrayList<String> fiastscn = new ArrayList<String>();
		int isfivelineandste = 0;
		ArrayList<String> fiastecn = new ArrayList<String>();
		int isfivelineandetn = 0;
		ArrayList<String> fiaetncn = new ArrayList<String>();
		int isfivelineandmtn = 0;
		ArrayList<String> fiamtncn = new ArrayList<String>();
		for(int i=0;i<citysinfo.size();i++) {
			if("一线城市".equals(citysinfo.get(i).getLevelName())) {
				if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 6) {
					isonelineandlesssix += 1;
					oalscn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 7) {
					isonelineandsixtoseven += 1;
					oastscn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 8) {
					isonelineandseventoeight += 1;
					oastecn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 9) {
					isonelineandeighttonine += 1;
					oaetncn.add(citysinfo.get(i).getCityName());
				}else {
					isonelineandmorethannine += 1;
					oamtncn.add(citysinfo.get(i).getCityName());
				}
			} else if("新一线城市".equals(citysinfo.get(i).getLevelName())) {
				if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 6) {
					isnewonelineandls += 1;
					noalscn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 7) {
					isnewonelineandsts += 1;
					noastscn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 8) {
					isnewonelineandste += 1;
					noastecn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 9) {
					isnewonelineandetn += 1;
					noaetncn.add(citysinfo.get(i).getCityName());
				}else {
					isnewonelineandmtn += 1;
					noamtncn.add(citysinfo.get(i).getCityName());
				}
			} else if("二线城市".equals(citysinfo.get(i).getLevelName())) {
				if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 6) {
					istwolineandls += 1;
					talscn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 7) {
					istwolineandsts += 1;
					tastscn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 8) {
					istwolineandste += 1;
					tastecn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 9) {
					istwolineandetn += 1;
					taetncn.add(citysinfo.get(i).getCityName());
				}else {
					istwolineandmtn += 1;
					tamtncn.add(citysinfo.get(i).getCityName());
				}
			} else if("三线城市".equals(citysinfo.get(i).getLevelName())) {
				if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 6) {
					isthreelineandls += 1;
					thalscn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 7) {
					isthreelineandsts += 1;
					thastscn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 8) {
					isthreelineandste += 1;
					thastecn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 9) {
					isthreelineandetn += 1;
					thaetncn.add(citysinfo.get(i).getCityName());
				}else {
					isthreelineandmtn += 1;
					thamtncn.add(citysinfo.get(i).getCityName());
				}
			} else if("四线城市".equals(citysinfo.get(i).getLevelName())) {
				if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 6) {
					isfourlineandls += 1;
					falscn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 7) {
					isfourlineandsts += 1;
					fastscn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 8) {
					isfourlineandste += 1;
					fastecn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 9) {
					isfourlineandetn += 1;
					faetncn.add(citysinfo.get(i).getCityName());
				}else {
					isfourlineandmtn += 1;
					famtncn.add(citysinfo.get(i).getCityName());
				}
			} else if("五线城市".equals(citysinfo.get(i).getLevelName())) {
				if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 6) {
					isfivelineandls += 1;
					fialscn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 7) {
					isfivelineandsts += 1;
					fiastscn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 8) {
					isfivelineandste += 1;
					fiastecn.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 9) {
					isfivelineandetn += 1;
					fiaetncn.add(citysinfo.get(i).getCityName());
				}else {
					isfivelineandmtn += 1;
					fiamtncn.add(citysinfo.get(i).getCityName());
				}
			} else {
				System.out.println("数据不存在");
			}		
		}
		ArrayList<Integer> d = new ArrayList<Integer>();
		d.add(isonelineandlesssix);
		d.add(isonelineandsixtoseven);
		d.add(isonelineandseventoeight);
		d.add(isonelineandeighttonine);
		d.add(isonelineandmorethannine);
		d.add(isnewonelineandls);
		d.add(isnewonelineandsts);
		d.add(isnewonelineandste);
		d.add(isnewonelineandetn);
		d.add(isnewonelineandmtn);
		d.add(istwolineandls);
		d.add(istwolineandsts);
		d.add(istwolineandste);
		d.add(istwolineandetn);
		d.add(istwolineandmtn);
		d.add(isthreelineandls);
		d.add(isthreelineandsts);
		d.add(isthreelineandste);
		d.add(isthreelineandetn);
		d.add(isthreelineandmtn);
		d.add(isfourlineandls);
		d.add(isfourlineandsts);
		d.add(isfourlineandste);
		d.add(isfourlineandetn);
		d.add(isfourlineandmtn);
		d.add(isfivelineandls);
		d.add(isfivelineandsts);
		d.add(isfivelineandste);
		d.add(isfivelineandetn);
		d.add(isfivelineandmtn);
		
		
		ArrayList<ArrayList<String>> citynamelist = new ArrayList<ArrayList<String>>();
		citynamelist.add(oalscn);
		citynamelist.add(oastscn);
		citynamelist.add(oastecn);
		citynamelist.add(oaetncn);
		citynamelist.add(oamtncn);
		citynamelist.add(noalscn);
		citynamelist.add(noastscn);
		citynamelist.add(noastecn);
		citynamelist.add(noaetncn);
		citynamelist.add(noamtncn);
		citynamelist.add(talscn);
		citynamelist.add(tastscn);
		citynamelist.add(tastecn);
		citynamelist.add(taetncn);
		citynamelist.add(tamtncn);
		citynamelist.add(thalscn);
		citynamelist.add(thastscn);
		citynamelist.add(thastecn);
		citynamelist.add(thaetncn);
		citynamelist.add(thamtncn);
		citynamelist.add(falscn);
		citynamelist.add(fastscn);
		citynamelist.add(fastecn);
		citynamelist.add(faetncn);
		citynamelist.add(famtncn);
		citynamelist.add(fialscn);
		citynamelist.add(fiastscn);
		citynamelist.add(fiastecn);
		citynamelist.add(fiaetncn);
		citynamelist.add(fiamtncn);
		
//		Map datamap = new HashMap();
		IdentityHashMap datamap = new IdentityHashMap();
//		datamap.put(d, citynamelist);
		
		
//		for(int index=0;index<d.size();index++) {
//			System.out.println(d.get(index));
//			System.out.println(d);
//		}

		for(int i=0;i<citynamelist.size();i++) {
//			datamap.put(d.get(i), citynamelist.get(i));
			datamap.put(citynamelist.get(i), d.get(i));
//			System.out.println(citynamelist.get(i));
		}
		System.out.println(d);
		return datamap;
	}
	
	@ResponseBody
	@RequestMapping(value="getCityName")
	public ArrayList getCityName() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_querycsa = "org.alex.entity.loginsMapper." + "queryCityInfos";
		List<ActivityCitysListVo> citysinfo = session.selectList(st_querycsa);
		
		ArrayList<String> iolals = new ArrayList<String>();
		ArrayList<String> iolasts = new ArrayList<String>();
		ArrayList<String> iolaste = new ArrayList<String>();
		ArrayList<String> iolaetn = new ArrayList<String>();
		ArrayList<String> iolamtn = new ArrayList<String>();
		
		ArrayList<String> inolals = new ArrayList<String>();
		ArrayList<String> inolasts = new ArrayList<String>();
		ArrayList<String> inolaste = new ArrayList<String>();
		ArrayList<String> inolaetn = new ArrayList<String>();
		ArrayList<String> inolamtn = new ArrayList<String>();
		
		ArrayList<String> iwlals = new ArrayList<String>();
		ArrayList<String> iwlasts = new ArrayList<String>();
		ArrayList<String> iwlaste = new ArrayList<String>();
		ArrayList<String> iwlaetn = new ArrayList<String>();
		ArrayList<String> iwlamtn = new ArrayList<String>();
		
		ArrayList<String> itlals = new ArrayList<String>();
		ArrayList<String> itlasts = new ArrayList<String>();
		ArrayList<String> itlaste = new ArrayList<String>();
		ArrayList<String> itlaetn = new ArrayList<String>();
		ArrayList<String> itlamtn = new ArrayList<String>();
		
		ArrayList<String> iflals = new ArrayList<String>();
		ArrayList<String> iflasts = new ArrayList<String>();
		ArrayList<String> iflaste = new ArrayList<String>();
		ArrayList<String> iflaetn = new ArrayList<String>();
		ArrayList<String> iflamtn = new ArrayList<String>();
		
		ArrayList<String> ifilals = new ArrayList<String>();
		ArrayList<String> ifilasts = new ArrayList<String>();
		ArrayList<String> ifilaste = new ArrayList<String>();
		ArrayList<String> ifilaetn = new ArrayList<String>();
		ArrayList<String> ifilamtn = new ArrayList<String>();
		
		for(int i=0;i<citysinfo.size();i++) {
			if("一线城市".equals(citysinfo.get(i).getLevelName())) {
				if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 6) {
					iolals.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 7) {
					iolasts.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 8) {
					iolaste.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 9) {
					iolaetn.add(citysinfo.get(i).getCityName());
				}else {
					iolamtn.add(citysinfo.get(i).getCityName());
				}
			} else if("新一线城市".equals(citysinfo.get(i).getLevelName())) {
				if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 6) {
					inolals.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 7) {
					inolasts.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 8) {
					inolaste.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 9) {
					inolaetn.add(citysinfo.get(i).getCityName());
				}else {
					inolamtn.add(citysinfo.get(i).getCityName());
				}
			} else if("二线城市".equals(citysinfo.get(i).getLevelName())) {
				if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 6) {
					iwlals.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 7) {
					iwlasts.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 8) {
					iwlaste.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 9) {
					iwlaetn.add(citysinfo.get(i).getCityName());
				}else {
					iwlamtn.add(citysinfo.get(i).getCityName());
				}
			} else if("三线城市".equals(citysinfo.get(i).getLevelName())) {
				if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 6) {
					itlals.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 7) {
					itlasts.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 8) {
					itlaste.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 9) {
					itlaetn.add(citysinfo.get(i).getCityName());
				}else {
					itlamtn.add(citysinfo.get(i).getCityName());
				}
			} else if("四线城市".equals(citysinfo.get(i).getLevelName())) {
				if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 6) {
					iflals.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 7) {
					iflasts.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 8) {
					iflaste.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 9) {
					iflaetn.add(citysinfo.get(i).getCityName());
				}else {
					iflamtn.add(citysinfo.get(i).getCityName());
				}
			} else if("五线城市".equals(citysinfo.get(i).getLevelName())) {
				if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 6) {
					ifilals.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 7) {
					ifilasts.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 8) {
					ifilaste.add(citysinfo.get(i).getCityName());
				}else if(Double.parseDouble(citysinfo.get(i).getSalaryAvg()) < 9) {
					ifilaetn.add(citysinfo.get(i).getCityName());
				}else {
					ifilamtn.add(citysinfo.get(i).getCityName());
				}
			} else {
				System.out.println("数据不存在");
			}		
		}
		ArrayList d = new ArrayList();
		d.add(iolals);
		d.add(iolasts);
		d.add(iolaste);
		d.add(iolaetn);
		d.add(iolamtn);
		d.add(inolals);
		d.add(inolasts);
		d.add(inolaste);
		d.add(inolaetn);
		d.add(inolamtn);
		d.add(iwlals);
		d.add(iwlasts);
		d.add(iwlaste);
		d.add(iwlaetn);
		d.add(iwlamtn);
		d.add(itlals);
		d.add(itlasts);
		d.add(itlaste);
		d.add(itlaetn);
		d.add(itlamtn);
		d.add(iflals);
		d.add(iflasts);
		d.add(iflaste);
		d.add(iflaetn);
		d.add(iflamtn);
		d.add(ifilals);
		d.add(ifilasts);
		d.add(ifilaste);
		d.add(ifilaetn);
		d.add(ifilamtn);

		

		
		for(int index=0;index<d.size();index++) {
			System.out.println(d.get(index));
		}
		
		return d;
	}
	
//	查询省份各个时间段的薪资数据，绘制折线图
	@ResponseBody
	@RequestMapping(value="getProvinceTimeSalary")
	public List<Map> getProvinceTimeSalary(@RequestParam(value="provinceID") String pid) throws IOException{
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_querypts = "org.alex.entity.loginsMapper." + "querypts";
		List<Map> ptsmap = session.selectList(st_querypts, pid);
		return ptsmap;
	}
	
	
//	根据参数调取某个地区的薪资数据，绘制折线图
	@ResponseBody
	@RequestMapping(value="getProvinceTimeSalaryWithArgs")
	public List<Map> getProvinceTimeSalaryWithArgs(@RequestParam(value="pinyin") String pinyin) throws IOException{
		System.out.println(pinyin);
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_querypts = "org.alex.entity.loginsMapper." + "queryptswa";
		List<Map> ptswamap = session.selectList(st_querypts, pinyin);
		return ptswamap;
	}
	
	
//	查询省份名称
	@ResponseBody
	@RequestMapping(value="getProvinceName")
	public List<Map> getProvinceName(@RequestParam(value="pinyin") String pinyin) throws IOException{
		System.out.println(pinyin);
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_querypts = "org.alex.entity.loginsMapper." + "queryprovincename";
		List<Map> pnmap = session.selectList(st_querypts, pinyin);
		return pnmap;
	}

}
