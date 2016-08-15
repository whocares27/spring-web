package rewards.web;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import rewards.application.RewardsApplicationService;
import rewards.domain.model.Account;

@Controller
@RequestMapping("/" + AccountsController.PATH)
public class AccountsController {

	public static final String PATH = "accounts";

	private RewardsApplicationService rewardsApplicationService;

	@Autowired
	public AccountsController(RewardsApplicationService rewardsApplicationService) {
		this.rewardsApplicationService = rewardsApplicationService;
	}

	@ModelAttribute
	protected AccountSearchCriteria getSearchCriteria() {
		return new AccountSearchCriteria();
	}

	protected List<Account> findAllAccounts(boolean fetchCards) {
		return rewardsApplicationService.findAllAccounts(fetchCards);
	}

	@RequestMapping(method=GET, produces={ TEXT_HTML_VALUE, ALL_VALUE })
	public String index(Model model) {
		model.addAttribute("accounts", findAllAccounts(false));
		return PATH + "/list";
	}

	protected List<Account> findAccountsByName(String searchString, boolean fetchCards) {
		return rewardsApplicationService.findAccountsByName(searchString, fetchCards);
	}

	@RequestMapping(method=GET, params={ "searchString" }, produces={ TEXT_HTML_VALUE, ALL_VALUE })
	public String search(
			AccountSearchCriteria searchCriteria, BindingResult result, Model model) {
		if (searchCriteria.getSearchString().isEmpty()) {
			return "redirect:" + PATH;
		}
		List<Account> accounts = findAccountsByName(searchCriteria.getSearchString(), false);
		if (accounts.size() == 1) {
			return "redirect:" + PATH + "/" + accounts.get(0).getNumber();
		} else {
			model.addAttribute("accounts", accounts);
			return PATH + "/list";
		}
	}

	@RequestMapping(method=GET, params={ "searchString" }, produces={ APPLICATION_JSON_VALUE })
	public @ResponseBody List<Account> findAccountsByName(
			AccountSearchCriteria searchCriteria, BindingResult result) {
		return findAccountsByName(searchCriteria.getSearchString(), true);
	}

	@RequestMapping(method=GET, produces={ APPLICATION_JSON_VALUE })
	public @ResponseBody List<Account> findAllAccounts() {
		return rewardsApplicationService.findAllAccounts(true);
	}

	@RequestMapping(method=POST, consumes={ APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public HttpEntity<Void> save(@RequestBody Account account,
			UriComponentsBuilder ucb) {
		rewardsApplicationService.updateAccount(account);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucb
				.path("/" + PATH + "/{number}")
				.buildAndExpand(account.getNumber())
				.toUri());
		return new HttpEntity<>(headers);
	}

	@ExceptionHandler({ org.springframework.dao.DataIntegrityViolationException.class })
	@ResponseStatus(CONFLICT)
	protected void conflict() {}

}
