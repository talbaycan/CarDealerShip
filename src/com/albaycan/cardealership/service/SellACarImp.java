	package src.com.albaycan.cardealership.service;

	import java.util.ArrayList;
	import java.util.List;

	import src.com.albaycan.cardealership.domain.CarSell;

	public class SellACarImp implements SellACar{

		List<CarSell> soldCars = new ArrayList<>();		

		@Override
		public void sellACar(CarSell carSell) {
		
			soldCars.add(carSell);
			
		}

		@Override
		public List<CarSell> listSoldCars() {
			
			return soldCars;
		}

}
