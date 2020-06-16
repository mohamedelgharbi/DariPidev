package tn.esprit.spring.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoRestController {
	/*@Autowired
	IBankService iBankService;

	ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	FileStorageService fileStorageService;

	@RequestMapping(value = AppConstants.EMPLOYEE_URI, method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public AppResponse createBank(
			@RequestParam(value = AppConstants.EMPLOYEE_JSON_PARAM, required = true) String empJson,
			@RequestParam(required = true, value = AppConstants.EMPLOYEE_FILE_PARAM) MultipartFile file)
			throws JsonParseException, JsonMappingException, IOException {
		String fileName = fileStorageService.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH)
				.path(fileName).toUriString();

		Bank bank = objectMapper.readValue(empJson, Bank.class);
		bank.setFilePath(fileDownloadUri);
		iBankService.addBank(bank);
		return new AppResponse(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MSG);
	}

	@RequestMapping(value = AppConstants.EMPLOYEE_URI, method = RequestMethod.GET)
	public List<Bank> getAllBanks() {
		return iBankService.getAllBanks();
	}

	@RequestMapping(value = AppConstants.DOWNLOAD_URI, method = RequestMethod.GET)
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		Resource resource = (Resource) fileStorageService.loadFileAsResource(fileName);
		String contentType = null;
		try {
			contentType = request.getServletContext()
					.getMimeType(((org.springframework.core.io.Resource) resource).getFile().getAbsolutePath());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		if (contentType == null) {
			contentType = AppConstants.DEFAULT_CONTENT_TYPE;
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, String.format(AppConstants.FILE_DOWNLOAD_HTTP_HEADER,
						((org.springframework.core.io.Resource) resource).getFilename()))
				.body(resource);
	}*/
}
