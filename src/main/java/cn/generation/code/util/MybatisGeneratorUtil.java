package cn.generation.code.util;

import org.apache.commons.lang.ObjectUtils;
import org.apache.velocity.VelocityContext;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import static cn.generation.code.util.StringUtil.lineToHump;
import static cn.generation.code.util.StringUtil.toLowerCaseFirstOne;


/**
 * 代码生成类
 * Created by ZhangShuzheng on 2017/1/10.
 */
public class MybatisGeneratorUtil {

	/**
	 * 模板路径
	 */
	private static String generatorConfig_vm = "/template/generatorConfig.vm";
	private static String service_vm = "/template/Service.vm";
	private static String serviceMock_vm = "/template/ServiceMock.vm";
	private static String serviceImpl_vm = "/template/ServiceImpl.vm";
	private static String controller_vm = "/template/Controller.vm";
	private static String saveDTO_vm = "/template/SaveDTO.vm";
	private static String updateDTO_vm = "/template/UpdateDTO.vm";
	private static String listDTO_vm = "/template/ListDTO.vm";
	private static String pageVO_vm = "/template/PageVO.vm";
	private static String modelVO_vm = "/template/ModelVO.vm";
	private static String result_vm = "/template/Result.vm";
	private static String resultEnum_vm = "/template/ResultEnum.vm";
	private static String resultUtil_vm = "/template/ResultUtil.vm";
	private static String customException_vm = "/template/CustomException.vm";
	private static String exceptionHandle_vm = "/template/ExceptionHandle.vm";

	/**
	 * 根据模板生成generatorConfig.xml文件
	 * @param jdbcDriver   驱动路径
	 * @param jdbcUrl      链接
	 * @param jdbcUsername 帐号
	 * @param jdbcPassword 密码
	 * @param module        项目模块
	 * @param database      数据库
	 * @param tablePrefix  表前缀
	 * @param packageName  包名
	 */
	public static void generator(
			String jdbcDriver,
			String jdbcUrl,
			String jdbcUsername,
			String jdbcPassword,
			String module,
			String database,
			String tablePrefix,
			String packageName,
			Map<String, String> lastInsertIdTables) throws Exception{

		String os = System.getProperty("os.name");
		String targetProject = module + "/" + module;
		String basePath = MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/classes/", "");//.replace(targetProject, "");
		if (os.toLowerCase().startsWith("win")) {
			generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath().replaceFirst("/", "");
			service_vm = MybatisGeneratorUtil.class.getResource(service_vm).getPath().replaceFirst("/", "");
			serviceMock_vm = MybatisGeneratorUtil.class.getResource(serviceMock_vm).getPath().replaceFirst("/", "");
			serviceImpl_vm = MybatisGeneratorUtil.class.getResource(serviceImpl_vm).getPath().replaceFirst("/", "");
			controller_vm = MybatisGeneratorUtil.class.getResource(controller_vm).getPath().replaceFirst("/", "");
			saveDTO_vm = MybatisGeneratorUtil.class.getResource(saveDTO_vm).getPath().replaceFirst("/", "");
			updateDTO_vm = MybatisGeneratorUtil.class.getResource(updateDTO_vm).getPath().replaceFirst("/", "");
			listDTO_vm = MybatisGeneratorUtil.class.getResource(listDTO_vm).getPath().replaceFirst("/", "");
			pageVO_vm = MybatisGeneratorUtil.class.getResource(pageVO_vm).getPath().replaceFirst("/", "");
			modelVO_vm = MybatisGeneratorUtil.class.getResource(modelVO_vm).getPath().replaceFirst("/", "");
			result_vm = MybatisGeneratorUtil.class.getResource(result_vm).getPath().replaceFirst("/","");
			resultEnum_vm = MybatisGeneratorUtil.class.getResource(resultEnum_vm).getPath().replaceFirst("/", "");
			resultUtil_vm = MybatisGeneratorUtil.class.getResource(resultUtil_vm).getPath().replaceFirst("/", "");
			customException_vm = MybatisGeneratorUtil.class.getResource(customException_vm).getPath().replaceFirst("/", "");
			exceptionHandle_vm = MybatisGeneratorUtil.class.getResource(exceptionHandle_vm).getPath().replaceFirst("/", "");

			basePath = basePath.replaceFirst("/", "");
		} else {
			generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath();
			service_vm = MybatisGeneratorUtil.class.getResource(service_vm).getPath();
			serviceMock_vm = MybatisGeneratorUtil.class.getResource(serviceMock_vm).getPath();
			serviceImpl_vm = MybatisGeneratorUtil.class.getResource(serviceImpl_vm).getPath();
			controller_vm = MybatisGeneratorUtil.class.getResource(controller_vm).getPath();
			saveDTO_vm = MybatisGeneratorUtil.class.getResource(saveDTO_vm).getPath();
			updateDTO_vm = MybatisGeneratorUtil.class.getResource(updateDTO_vm).getPath();
			listDTO_vm = MybatisGeneratorUtil.class.getResource(listDTO_vm).getPath();
			pageVO_vm = MybatisGeneratorUtil.class.getResource(pageVO_vm).getPath();
			modelVO_vm = MybatisGeneratorUtil.class.getResource(modelVO_vm).getPath();
			result_vm = MybatisGeneratorUtil.class.getResource(result_vm).getPath();
			resultEnum_vm = MybatisGeneratorUtil.class.getResource(resultEnum_vm).getPath();
			resultUtil_vm = MybatisGeneratorUtil.class.getResource(resultUtil_vm).getPath();
			customException_vm = MybatisGeneratorUtil.class.getResource(customException_vm).getPath();
			exceptionHandle_vm = MybatisGeneratorUtil.class.getResource(exceptionHandle_vm).getPath();
		}

		String generatorConfigXml = MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/classes/", "") + "/src/main/resources/generatorConfig.xml";
		targetProject = basePath + targetProject;
		String sql = "SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '" + database + "' AND table_name LIKE '" + tablePrefix + "_%';";

		System.out.println("========== 开始生成generatorConfig.xml文件 ==========");
		List<Map<String, Object>> tables = new ArrayList<>();
		try {
			VelocityContext context = new VelocityContext();
			Map<String, Object> table;

			// 查询定制前缀项目的所有表
			JdbcUtil jdbcUtil = new JdbcUtil(jdbcDriver, jdbcUrl, jdbcUsername, AESUtil.aesDecode(jdbcPassword));
			List<Map> result = jdbcUtil.selectByParams(sql, null);
			for (Map map : result) {
				System.out.println(map.get("TABLE_NAME"));
				table = new HashMap<>(2);
				table.put("table_name", map.get("TABLE_NAME"));
				table.put("model_name", lineToHump(ObjectUtils.toString(map.get("TABLE_NAME"))));
				tables.add(table);
			}
			jdbcUtil.release();

			//mapper xml生成的位置
			String targetProjectSqlMap = basePath + module + "/" + module;
			context.put("tables", tables);
			context.put("generator_javaModelGenerator_targetPackage", packageName + ".model");
			context.put("generator_sqlMapGenerator_targetPackage", packageName + ".mapper");
			context.put("generator_javaClientGenerator_targetPackage", packageName + ".mapper");
			context.put("targetProject", targetProject);
			context.put("targetProject_sqlMap", targetProjectSqlMap);
			context.put("generator_jdbc_password", AESUtil.aesDecode(jdbcPassword));
			context.put("last_insert_id_tables", lastInsertIdTables);
			VelocityUtil.generate(generatorConfig_vm, generatorConfigXml, context);
			// 删除旧代码
			deleteDir(new File(targetProject + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dao/model"));
			deleteDir(new File(targetProject + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dao/mapper"));
			deleteDir(new File(targetProjectSqlMap + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dao/mapper"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("========== 结束生成generatorConfig.xml文件 ==========");

		System.out.println("========== 开始运行MybatisGenerator ==========");
		List<String> warnings = new ArrayList<>();
		File configFile = new File(generatorConfigXml);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		for (String warning : warnings) {
			System.out.println(warning);
		}
		System.out.println("========== 结束运行MybatisGenerator ==========");

		System.out.println("========== 开始生成Service ==========");
		String ctime = new SimpleDateFormat("yyyy/M/d").format(new Date());
		String servicePath = basePath + module + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/service";
		String serviceImplPath = basePath + module + "/" + module + "src/main/java/" + packageName.replaceAll("\\.", "/") + "/service/impl";
		String controllerPath = basePath + module + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/controller";
		String saveDTOPath = basePath + module + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dto";
		String updateDTOPath = basePath + module + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dto";
		String listDTOPath = basePath + module + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dto";
		String pageVOPath = basePath + module + "/src/main/java/" + packageName.replaceAll("\\.","/") + "/core/resp";
		String modelVOPath = basePath + module + "/src/main/java/" + packageName.replaceAll("\\.","/") + "/vo";
		String resultPath = basePath + module + "/src/main/java/" + packageName.replaceAll("\\.","/") + "/core/resp";
		String resultEnumPath = basePath + module + "/src/main/java/" + packageName.replaceAll("\\.","/") + "/core/enums";
		String resultUtilPath = basePath + module + "/src/main/java/" + packageName.replaceAll("\\.","/") + "/core/resp";
		String customExceptionPath = basePath + module + "/src/main/java/" + packageName.replaceAll("\\.","/") + "/core/exception";
		String exceptionHandlePath = basePath + module + "/src/main/java/" + packageName.replaceAll("\\.","/") + "/core/exception";
		for (int i = 0; i < tables.size(); i++) {
			String model = lineToHump(ObjectUtils.toString(tables.get(i).get("table_name")));
			String lowerCaseModel = toLowerCaseFirstOne(lineToHump(ObjectUtils.toString(tables.get(i).get("table_name"))));
			String service = servicePath + "/" + model + "Service.java";
			String serviceMock = servicePath + "/" + model + "ServiceMock.java";
			String serviceImpl = serviceImplPath + "/" + model + "ServiceImpl.java";
			String controller = controllerPath + "/" + model + "Controller.java";
			String saveDTO = saveDTOPath + "/" + lowerCaseModel + "/" + model+ "SaveDTO.java";
			String updateDTO = updateDTOPath + "/" + lowerCaseModel + "/" + model + "UpdateDTO.java";
			String listDTO = listDTOPath + "/" + lowerCaseModel + "/" + model + "ListDTO.java";
			String modelVO = modelVOPath + "/" + lowerCaseModel + "/" + model + "VO.java";

			System.out.println("===========开始生成ModelVO==========");
			File modelVOFile = new File(modelVO);
			if (!modelVOFile.exists()) {
				modelVOFile.getParentFile().mkdirs();
				modelVOFile.createNewFile();

				VelocityContext context = new VelocityContext();
				context.put("package_name", packageName);
				context.put("model", lowerCaseModel);
				context.put("Model", model);
				context.put("ctime", ctime);
				VelocityUtil.generate(modelVO_vm, modelVO, context);
				System.out.println(modelVO);
			}
			System.out.println("===========结束生成ModelVO==========");
			// 生成service
			File serviceFile = new File(service);
			if (!serviceFile.exists()) {
				serviceFile.getParentFile().mkdirs();
				serviceFile.createNewFile();

				VelocityContext context = new VelocityContext();
				context.put("package_name", packageName);
				context.put("model", lowerCaseModel);
				context.put("Model", model);
				context.put("ctime", ctime);
				VelocityUtil.generate(service_vm, service, context);
				System.out.println(service);
			}
			// 生成serviceMock
			/*File serviceMockFile = new File(serviceMock);
			if (!serviceMockFile.exists()) {
				VelocityContext context = new VelocityContext();
				context.put("package_name", packageName);
				context.put("model", model);
				context.put("ctime", ctime);
				VelocityUtil.generate(serviceMock_vm, serviceMock, context);
				System.out.println(serviceMock);
			}*/
			// 生成serviceImpl
			File serviceImplFile = new File(serviceImpl);
			if (!serviceImplFile.exists()) {
				serviceImplFile.getParentFile().mkdirs();
				serviceImplFile.createNewFile();

				VelocityContext context = new VelocityContext();
				context.put("package_name", packageName);
				context.put("model", lowerCaseModel);
				context.put("Model", model);
				context.put("mapper", toLowerCaseFirstOne(model));
				context.put("ctime", ctime);
				VelocityUtil.generate(serviceImpl_vm, serviceImpl, context);
				System.out.println(serviceImpl);
			}
			//生成Controller
			File controllerFile = new File(controller);
			if (!controllerFile.exists()) {
				controllerFile.getParentFile().mkdirs();
				controllerFile.createNewFile();

				VelocityContext context = new VelocityContext();
				context.put("package_name", packageName);
				context.put("model", lowerCaseModel);
				context.put("path", tables.get(i).get("table_name"));
				context.put("Model", model);
				context.put("ctime", ctime);
				VelocityUtil.generate(controller_vm, controller, context);
				System.out.println(controller);
			}
			//生成SaveDTO
			File saveDTOFile = new File(saveDTO);
			if (!saveDTOFile.getParentFile().exists()) {
				saveDTOFile.getParentFile().mkdirs();
			}
			if (!saveDTOFile.exists()) {
				VelocityContext context = new VelocityContext();
				context.put("package_name", packageName);
				context.put("model", lowerCaseModel);
				context.put("Model", model);
				context.put("ctime", ctime);
				VelocityUtil.generate(saveDTO_vm, saveDTO, context);
				System.out.println(saveDTO);
			}
			//生成updateDTO
			File updateDTOFile = new File(updateDTO);
			if (!updateDTOFile.getParentFile().exists()){
				updateDTOFile.getParentFile().mkdirs();
			}
			if (!updateDTOFile.exists()){
				VelocityContext context = new VelocityContext();
				context.put("package_name", packageName);
				context.put("model", lowerCaseModel);
				context.put("Model", model);
				context.put("ctime", ctime);
				VelocityUtil.generate(updateDTO_vm, updateDTO, context);
				System.out.println(updateDTO);
			}
			//生成ListDTO
			File listDTOFile = new File(listDTO);
			if (!saveDTOFile.getParentFile().exists()) {
				saveDTOFile.getParentFile().mkdirs();
			}
			if (!listDTOFile.exists()) {
				VelocityContext context = new VelocityContext();
				context.put("package_name", packageName);
				context.put("model", lowerCaseModel);
				context.put("Model", model);
				context.put("ctime", ctime);
				VelocityUtil.generate(listDTO_vm, listDTO, context);
				System.out.println(listDTO);
			}

		}
		System.out.println("========== 结束生成Service ==========");

		System.out.println("===========开始生产分页返回结果pageVO==========");
		String pageVO = pageVOPath + "/PageVO.java";
		File pageVOFile = new File(pageVO);
		if (!pageVOFile.exists()){
			pageVOFile.getParentFile().mkdirs();
			pageVOFile.createNewFile();

			VelocityContext context = new VelocityContext();
			context.put("package_name", packageName);
			context.put("ctime", ctime);
			VelocityUtil.generate(pageVO_vm, pageVO, context);
			System.out.println(pageVO);
		}
		System.out.println("===========结束生产分页返回结果pageVO==========");

		System.out.println("===========开始生成result==========");
		String result = resultPath + "/Result.java";
		File resultFile = new File(result);
		if (!resultFile.exists()){
			resultFile.getParentFile().mkdirs();
			resultFile.createNewFile();

			VelocityContext context = new VelocityContext();
			context.put("package_name", packageName);
			context.put("ctime", ctime);
			VelocityUtil.generate(result_vm, result, context);
			System.out.println(result);
		}
		System.out.println("===========结束生成result==========");

		System.out.println("==========开始生成resultEnum===========");
		String resultEnum = resultEnumPath + "/ResultEnum.java";
		File resultEnumFile = new File(resultEnum);
		if (!resultEnumFile.exists()){
			resultEnumFile.getParentFile().mkdirs();
			resultEnumFile.createNewFile();

			VelocityContext context = new VelocityContext();
			context.put("package_name", packageName);
			context.put("ctime", ctime);
			VelocityUtil.generate(resultEnum_vm, resultEnum, context);
			System.out.println(resultEnum);
		}
		System.out.println("==========结束生成resultEnum===========");

		System.out.println("==========开始生成resultUtil===========");
		String resultUtil = resultUtilPath + "/ResultUtil.java";
		File resultUtilFile = new File(resultUtil);
		if (!resultUtilFile.exists()){
			resultUtilFile.getParentFile().mkdirs();
			resultUtilFile.createNewFile();

			VelocityContext context = new VelocityContext();
			context.put("package_name", packageName);
			context.put("ctime", ctime);
			VelocityUtil.generate(resultUtil_vm, resultUtil, context);
			System.out.println(resultUtil);
		}
		System.out.println("==========结束生成resultUtil===========");

		System.out.println("==========开始生成CustomException===========");
		String customException = customExceptionPath + "/CustomException.java";
		File customExceptionFile = new File(customException);
		if (!customExceptionFile.exists()){
			customExceptionFile.getParentFile().mkdirs();
			customExceptionFile.createNewFile();

			VelocityContext context = new VelocityContext();
			context.put("package_name", packageName);
			context.put("ctime", ctime);
			VelocityUtil.generate(customException_vm, customException, context);
			System.out.println(customException);
		}
		System.out.println("==========结束生成CustomException===========");

		System.out.println("==========开始生成ExceptionHandle===========");
		String exceptionHandle = exceptionHandlePath + "/ExceptionHandle.java";
		File exceptionHandleFile = new File(exceptionHandle);
		if (!exceptionHandleFile.exists()){
			exceptionHandleFile.getParentFile().mkdirs();
			exceptionHandleFile.createNewFile();

			VelocityContext context = new VelocityContext();
			context.put("package_name", packageName);
			context.put("ctime", ctime);
			VelocityUtil.generate(exceptionHandle_vm, exceptionHandle, context);
			System.out.println(exceptionHandle);
		}
		System.out.println("==========结束生成ExceptionHandle===========");
	}


	// 递归删除非空文件夹
	public static void deleteDir(File dir) {
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteDir(files[i]);
			}
		}
		dir.delete();
	}

}
