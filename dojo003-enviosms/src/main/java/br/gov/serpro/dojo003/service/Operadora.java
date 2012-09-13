package br.gov.serpro.dojo003.service;

public enum Operadora implements Network {

	CLARO {
		public Long getSMSTax() {
			return 2L;
		}

		public int getAvailability() {
			return 4;
		}
	},
	OI {
		public Long getSMSTax() {
			return 1L;
		}

		public int getAvailability() {
			return 3;
		}
	},
	TIM {
		public Long getSMSTax() {
			return 4L;
		}

		public int getAvailability() {
			return 2;
		}
	},
	VIVO {
		public Long getSMSTax() {
			return 3L;
		}

		public int getAvailability() {
			return 4;
		}
	};

}
