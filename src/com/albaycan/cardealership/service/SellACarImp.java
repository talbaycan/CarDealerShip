	package src.com.albaycan.cardealership.service;

	import java.util.ArrayList;
	import java.util.List;

import src.com.albaycan.cardealership.data.SellACarRepository;
import src.com.albaycan.cardealership.data.SellACarRepositoryImp;
import src.com.albaycan.cardealership.domain.CarSell;

	public class SellACarImp implements SellACar{

		SellACarRepository sellACarRepository = new SellACarRepositoryImp();
		
		List<CarSell> soldCars = new ArrayList<>();		

		@Override
		public void sellACar(CarSell carSell) throws Exception {
		
			// soldCars.add(carSell);
			sellACarRepository.sellACar(carSell);
		}

		@Override
		public List<CarSell> listSoldCars() throws Exception {
			
			// return soldCars;
			return sellACarRepository.listSoldCars();
		}

}
