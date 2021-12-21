package be.fooda.bridge.paypal.model.order.detail.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodaBridgePayPalOrderDetailRes{
	private String createTime;
	private List<FoodaBridgePayPalOrderDetailPurchaseUnitsItem> purchaseUnits;
	private List<FoodaBridgePayPalOrderDetailLinksItem> links;
	private String id;
	private FoodaBridgePayPalOrderDetailPaymentSource paymentSource;
	private String intent;
	private String status;
}