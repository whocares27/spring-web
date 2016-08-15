package rewards.domain.model;

import java.util.Date;

import common.Money;
import common.domain.model.GenericRepository;

public interface RewardRepository extends GenericRepository<Reward, String> {

	/**
	 * Returns reward confirmation number.
	 * @param accountNumber rewards account number
	 * @param cardNumber card used for purchase
	 * @param merchantNumber merchant number
	 * @param purchaseAmount amount purchased
	 * @param purchaseDate purchase date
	 * @param pointsEarned points earned for the purchase
	 * @return reward confirmation number.
	 */
	String confirmReward(
			String accountNumber, String cardNumber, String merchantNumber,
			Money purchaseAmount, Date purchaseDate, RewardPoints pointsEarned);

	// Reward findReward(String confirmationNumber);

}
