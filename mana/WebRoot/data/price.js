//匹配 时段+秒数（规格）= 金额
function getprice(meiti2,shiduan,guige) {
	var result = 0;
	if(meiti2 == "FM103.8/吉林交通广播") {
		switch (shiduan) {
			case "07:27":if(guige==5)result=1370;if(guige==10)result=2700;if(guige==15)result=4100;if(guige==20)result=5500;if(guige==30)result=8200;break;
			case "07:42":if(guige==5)result=1370;if(guige==10)result=2700;if(guige==15)result=4100;if(guige==20)result=5500;if(guige==30)result=8200;break;
			case "07:56":if(guige==5)result=1260;if(guige==10)result=2500;if(guige==15)result=3600;if(guige==20)result=4800;if(guige==30)result=7100;break;
			case "17:42":if(guige==5)result=1260;if(guige==10)result=2500;if(guige==15)result=3600;if(guige==20)result=4800;if(guige==30)result=7100;break;
			case "08:12":if(guige==5)result=760;if(guige==10)result=1600;if(guige==15)result=2300;if(guige==20)result=3000;if(guige==30)result=4600;break;
			case "17:30":if(guige==5)result=760;if(guige==10)result=1600;if(guige==15)result=2300;if(guige==20)result=3000;if(guige==30)result=4600;break;
			case "07:12":if(guige==5)result=680;if(guige==10)result=1400;if(guige==15)result=2000;if(guige==20)result=2800;if(guige==30)result=4100;break;
			case "08:27":if(guige==5)result=680;if(guige==10)result=1400;if(guige==15)result=2000;if(guige==20)result=2800;if(guige==30)result=4100;break;
			case "16:42":if(guige==5)result=680;if(guige==10)result=1400;if(guige==15)result=2000;if(guige==20)result=2800;if(guige==30)result=4100;break;
			case "17:12":if(guige==5)result=680;if(guige==10)result=1400;if(guige==15)result=2000;if(guige==20)result=2800;if(guige==30)result=4100;break;
			case "08:42":if(guige==5)result=650;if(guige==10)result=1260;if(guige==15)result=1800;if(guige==20)result=2600;if(guige==30)result=3800;break;
			case "08:56":if(guige==5)result=650;if(guige==10)result=1260;if(guige==15)result=1800;if(guige==20)result=2600;if(guige==30)result=3800;break;
			case "09:12":if(guige==5)result=650;if(guige==10)result=1260;if(guige==15)result=1800;if(guige==20)result=2600;if(guige==30)result=3800;break;
			case "16:56":if(guige==5)result=650;if(guige==10)result=1260;if(guige==15)result=1800;if(guige==20)result=2600;if(guige==30)result=3800;break;
			case "17:56":if(guige==5)result=650;if(guige==10)result=1260;if(guige==15)result=1800;if(guige==20)result=2600;if(guige==30)result=3800;break;
			case "09:27":if(guige==5)result=550;if(guige==10)result=1150;if(guige==15)result=1600;if(guige==20)result=2300;if(guige==30)result=3200;break;
			case "09:42":if(guige==5)result=550;if(guige==10)result=1150;if(guige==15)result=1600;if(guige==20)result=2300;if(guige==30)result=3200;break;
			case "16:27":if(guige==5)result=550;if(guige==10)result=1150;if(guige==15)result=1600;if(guige==20)result=2300;if(guige==30)result=3200;break;
			case "18:12":if(guige==5)result=550;if(guige==10)result=1150;if(guige==15)result=1600;if(guige==20)result=2300;if(guige==30)result=3200;break;
			case "09:56":if(guige==5)result=410;if(guige==10)result=820;if(guige==15)result=1300;if(guige==20)result=1700;if(guige==30)result=2500;break;
			case "10:12":if(guige==5)result=410;if(guige==10)result=820;if(guige==15)result=1300;if(guige==20)result=1700;if(guige==30)result=2500;break;
			case "14:12":if(guige==5)result=410;if(guige==10)result=820;if(guige==15)result=1300;if(guige==20)result=1700;if(guige==30)result=2500;break;
			case "18:27":if(guige==5)result=410;if(guige==10)result=820;if(guige==15)result=1300;if(guige==20)result=1700;if(guige==30)result=2500;break;
			case "07:00":if(guige==5)result=360;if(guige==10)result=760;if(guige==15)result=1200;if(guige==20)result=1490;if(guige==30)result=2300;break;
			case "10:27":if(guige==5)result=360;if(guige==10)result=760;if(guige==15)result=1200;if(guige==20)result=1490;if(guige==30)result=2300;break;
			case "16:12":if(guige==5)result=360;if(guige==10)result=760;if(guige==15)result=1200;if(guige==20)result=1490;if(guige==30)result=2300;break;
			case "18:42":if(guige==5)result=360;if(guige==10)result=760;if(guige==15)result=1200;if(guige==20)result=1490;if(guige==30)result=2300;break;
			case "14:27":if(guige==5)result=360;if(guige==10)result=760;if(guige==15)result=1200;if(guige==20)result=1490;if(guige==30)result=2300;break;
			case "10:42":if(guige==5)result=320;if(guige==10)result=690;if(guige==15)result=970;if(guige==20)result=1380;if(guige==30)result=1950;break;
			case "10:56":if(guige==5)result=320;if(guige==10)result=690;if(guige==15)result=970;if(guige==20)result=1380;if(guige==30)result=1950;break;
			case "11:12":if(guige==5)result=320;if(guige==10)result=690;if(guige==15)result=970;if(guige==20)result=1380;if(guige==30)result=1950;break;
			case "11:27":if(guige==5)result=320;if(guige==10)result=690;if(guige==15)result=970;if(guige==20)result=1380;if(guige==30)result=1950;break;
			case "11:42":if(guige==5)result=320;if(guige==10)result=690;if(guige==15)result=970;if(guige==20)result=1380;if(guige==30)result=1950;break;
			case "14:42":if(guige==5)result=320;if(guige==10)result=690;if(guige==15)result=970;if(guige==20)result=1380;if(guige==30)result=1950;break;
			case "15:42":if(guige==5)result=320;if(guige==10)result=690;if(guige==15)result=970;if(guige==20)result=1380;if(guige==30)result=1950;break;
			case "15:56":if(guige==5)result=320;if(guige==10)result=690;if(guige==15)result=970;if(guige==20)result=1380;if(guige==30)result=1950;break;
			case "18:56":if(guige==5)result=320;if(guige==10)result=690;if(guige==15)result=970;if(guige==20)result=1380;if(guige==30)result=1950;break;
			case "13:12":if(guige==5)result=280;if(guige==10)result=570;if(guige==15)result=840;if(guige==20)result=1150;if(guige==30)result=1600;break;
			case "13:27":if(guige==5)result=280;if(guige==10)result=570;if(guige==15)result=840;if(guige==20)result=1150;if(guige==30)result=1600;break;
			case "15:12":if(guige==5)result=280;if(guige==10)result=570;if(guige==15)result=840;if(guige==20)result=1150;if(guige==30)result=1600;break;
			case "15:27":if(guige==5)result=280;if(guige==10)result=570;if(guige==15)result=840;if(guige==20)result=1150;if(guige==30)result=1600;break;
			case "14:56":if(guige==5)result=280;if(guige==10)result=570;if(guige==15)result=840;if(guige==20)result=1150;if(guige==30)result=1600;break;
			case "11:56":if(guige==5)result=200;if(guige==10)result=400;if(guige==15)result=550;if(guige==20)result=800;if(guige==30)result=1150;break;
			case "12:12":if(guige==5)result=200;if(guige==10)result=400;if(guige==15)result=550;if(guige==20)result=800;if(guige==30)result=1150;break;
			case "12:27":if(guige==5)result=200;if(guige==10)result=400;if(guige==15)result=550;if(guige==20)result=800;if(guige==30)result=1150;break;
			case "12:42":if(guige==5)result=200;if(guige==10)result=400;if(guige==15)result=550;if(guige==20)result=800;if(guige==30)result=1150;break;
			case "12:56":if(guige==5)result=200;if(guige==10)result=400;if(guige==15)result=550;if(guige==20)result=800;if(guige==30)result=1150;break;
			case "13:42":if(guige==5)result=200;if(guige==10)result=400;if(guige==15)result=550;if(guige==20)result=800;if(guige==30)result=1150;break;
			case "13:56":if(guige==5)result=200;if(guige==10)result=400;if(guige==15)result=550;if(guige==20)result=800;if(guige==30)result=1150;break;
			case "19:12":if(guige==5)result=200;if(guige==10)result=400;if(guige==15)result=550;if(guige==20)result=800;if(guige==30)result=1150;break;
			case "19:27":if(guige==5)result=110;if(guige==10)result=200;if(guige==15)result=280;if(guige==20)result=410;if(guige==30)result=580;break;
			case "19:42":if(guige==5)result=110;if(guige==10)result=200;if(guige==15)result=280;if(guige==20)result=410;if(guige==30)result=580;break;
			case "19:56":if(guige==5)result=110;if(guige==10)result=200;if(guige==15)result=280;if(guige==20)result=410;if(guige==30)result=580;break;
			case "20:12":if(guige==5)result=110;if(guige==10)result=200;if(guige==15)result=280;if(guige==20)result=410;if(guige==30)result=580;break;
			case "20:27":if(guige==5)result=110;if(guige==10)result=200;if(guige==15)result=280;if(guige==20)result=410;if(guige==30)result=580;break;
			case "20:42":if(guige==5)result=110;if(guige==10)result=200;if(guige==15)result=280;if(guige==20)result=410;if(guige==30)result=580;break;
			case "20:56":if(guige==5)result=110;if(guige==10)result=200;if(guige==15)result=280;if(guige==20)result=410;if(guige==30)result=580;break;
			case "21:12":if(guige==5)result=110;if(guige==10)result=200;if(guige==15)result=280;if(guige==20)result=410;if(guige==30)result=580;break;
			case "21:27":if(guige==5)result=110;if(guige==10)result=200;if(guige==15)result=280;if(guige==20)result=410;if(guige==30)result=580;break;
			case "21:42":if(guige==5)result=110;if(guige==10)result=200;if(guige==15)result=280;if(guige==20)result=410;if(guige==30)result=580;break;
			case "21:56":if(guige==5)result=110;if(guige==10)result=200;if(guige==15)result=280;if(guige==20)result=410;if(guige==30)result=580;break;
			case "22:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "23:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "23:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "00:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "00:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "01:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "01:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "02:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "02:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "03:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "03:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "04:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "04:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "05:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "05:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "06:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "06:15":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "06:27":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
		}
	}
	if(meiti2 == "FM100.1/吉林资讯广播") {
		switch (shiduan) {
			case "07:42":if(guige==5)result=490;if(guige==10)result=970;if(guige==15)result=1400;if(guige==20)result=1950;if(guige==30)result=2800;break;
			case "07:56":if(guige==5)result=490;if(guige==10)result=970;if(guige==15)result=1400;if(guige==20)result=1950;if(guige==30)result=2800;break;
			case "07:27":if(guige==5)result=420;if(guige==10)result=810;if(guige==15)result=1270;if(guige==20)result=1560;if(guige==30)result=2300;break;
			case "17:27":if(guige==5)result=420;if(guige==10)result=810;if(guige==15)result=1270;if(guige==20)result=1560;if(guige==30)result=2300;break;
			case "08:12":if(guige==5)result=350;if(guige==10)result=700;if(guige==15)result=1100;if(guige==20)result=1380;if(guige==30)result=2000;break;
			case "16:56":if(guige==5)result=350;if(guige==10)result=700;if(guige==15)result=1100;if(guige==20)result=1380;if(guige==30)result=2000;break;
			case "17:12":if(guige==5)result=350;if(guige==10)result=700;if(guige==15)result=1100;if(guige==20)result=1380;if(guige==30)result=2000;break;
			case "17:42":if(guige==5)result=350;if(guige==10)result=700;if(guige==15)result=1100;if(guige==20)result=1380;if(guige==30)result=2000;break;
			case "08:27":if(guige==5)result=300;if(guige==10)result=640;if(guige==15)result=920;if(guige==20)result=1270;if(guige==30)result=1780;break;
			case "08:42":if(guige==5)result=300;if(guige==10)result=640;if(guige==15)result=920;if(guige==20)result=1270;if(guige==30)result=1780;break;
			case "09:42":if(guige==5)result=300;if(guige==10)result=640;if(guige==15)result=920;if(guige==20)result=1270;if(guige==30)result=1780;break;
			case "16:42":if(guige==5)result=300;if(guige==10)result=640;if(guige==15)result=920;if(guige==20)result=1270;if(guige==30)result=1780;break;
			case "17:56":if(guige==5)result=300;if(guige==10)result=640;if(guige==15)result=920;if(guige==20)result=1270;if(guige==30)result=1780;break;
			case "18:12":if(guige==5)result=300;if(guige==10)result=640;if(guige==15)result=920;if(guige==20)result=1270;if(guige==30)result=1780;break;
			case "18:27":if(guige==5)result=300;if(guige==10)result=640;if(guige==15)result=920;if(guige==20)result=1270;if(guige==30)result=1780;break;
			case "18:42":if(guige==5)result=300;if(guige==10)result=640;if(guige==15)result=920;if(guige==20)result=1270;if(guige==30)result=1780;break;
			case "08:56":if(guige==5)result=280;if(guige==10)result=580;if(guige==15)result=870;if(guige==20)result=1150;if(guige==30)result=1650;break;
			case "09:56":if(guige==5)result=280;if(guige==10)result=580;if(guige==15)result=870;if(guige==20)result=1150;if(guige==30)result=1650;break;
			case "10:12":if(guige==5)result=280;if(guige==10)result=580;if(guige==15)result=870;if(guige==20)result=1150;if(guige==30)result=1650;break;
			case "16:27":if(guige==5)result=280;if(guige==10)result=580;if(guige==15)result=870;if(guige==20)result=1150;if(guige==30)result=1650;break;
			case "07:12":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=800;if(guige==20)result=1000;if(guige==30)result=1500;break;
			case "10:27":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=800;if(guige==20)result=1000;if(guige==30)result=1500;break;
			case "10:42":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=800;if(guige==20)result=1000;if(guige==30)result=1500;break;
			case "10:56":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=800;if(guige==20)result=1000;if(guige==30)result=1500;break;
			case "11:12":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=800;if(guige==20)result=1000;if(guige==30)result=1500;break;
			case "11:27":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=800;if(guige==20)result=1000;if(guige==30)result=1500;break;
			case "16:12":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=800;if(guige==20)result=1000;if(guige==30)result=1500;break;
			case "06:56":if(guige==5)result=200;if(guige==10)result=460;if(guige==15)result=750;if(guige==20)result=870;if(guige==30)result=1150;break;
			case "09:12":if(guige==5)result=200;if(guige==10)result=460;if(guige==15)result=750;if(guige==20)result=870;if(guige==30)result=1150;break;
			case "09:27":if(guige==5)result=200;if(guige==10)result=460;if(guige==15)result=750;if(guige==20)result=870;if(guige==30)result=1150;break;
			case "15:56":if(guige==5)result=200;if(guige==10)result=460;if(guige==15)result=750;if(guige==20)result=870;if(guige==30)result=1150;break;
			case "18:56":if(guige==5)result=200;if(guige==10)result=460;if(guige==15)result=750;if(guige==20)result=870;if(guige==30)result=1150;break;
			case "11:42":if(guige==5)result=170;if(guige==10)result=400;if(guige==15)result=580;if(guige==20)result=640;if(guige==30)result=970;break;
			case "11:56":if(guige==5)result=170;if(guige==10)result=400;if(guige==15)result=580;if(guige==20)result=640;if(guige==30)result=970;break;
			case "12:12":if(guige==5)result=170;if(guige==10)result=400;if(guige==15)result=580;if(guige==20)result=640;if(guige==30)result=970;break;
			case "12:27":if(guige==5)result=170;if(guige==10)result=400;if(guige==15)result=580;if(guige==20)result=640;if(guige==30)result=970;break;
			case "12:42":if(guige==5)result=170;if(guige==10)result=400;if(guige==15)result=580;if(guige==20)result=640;if(guige==30)result=970;break;
			case "06:27":if(guige==5)result=140;if(guige==10)result=280;if(guige==15)result=350;if(guige==20)result=480;if(guige==30)result=730;break;
			case "12:56":if(guige==5)result=140;if(guige==10)result=280;if(guige==15)result=350;if(guige==20)result=480;if(guige==30)result=730;break;
			case "13:12":if(guige==5)result=140;if(guige==10)result=280;if(guige==15)result=350;if(guige==20)result=480;if(guige==30)result=730;break;
			case "13:27":if(guige==5)result=140;if(guige==10)result=280;if(guige==15)result=350;if(guige==20)result=480;if(guige==30)result=730;break;
			case "13:42":if(guige==5)result=140;if(guige==10)result=280;if(guige==15)result=350;if(guige==20)result=480;if(guige==30)result=730;break;
			case "15:12":if(guige==5)result=140;if(guige==10)result=280;if(guige==15)result=350;if(guige==20)result=480;if(guige==30)result=730;break;
			case "15:27":if(guige==5)result=140;if(guige==10)result=280;if(guige==15)result=350;if(guige==20)result=480;if(guige==30)result=730;break;
			case "13:56":if(guige==5)result=110;if(guige==10)result=210;if(guige==15)result=280;if(guige==20)result=370;if(guige==30)result=560;break;
			case "14:12":if(guige==5)result=110;if(guige==10)result=210;if(guige==15)result=280;if(guige==20)result=370;if(guige==30)result=560;break;
			case "14:27":if(guige==5)result=110;if(guige==10)result=210;if(guige==15)result=280;if(guige==20)result=370;if(guige==30)result=560;break;
			case "14:42":if(guige==5)result=110;if(guige==10)result=210;if(guige==15)result=280;if(guige==20)result=370;if(guige==30)result=560;break;
			case "14:56":if(guige==5)result=110;if(guige==10)result=210;if(guige==15)result=280;if(guige==20)result=370;if(guige==30)result=560;break;
			case "15:42":if(guige==5)result=110;if(guige==10)result=210;if(guige==15)result=280;if(guige==20)result=370;if(guige==30)result=560;break;
			case "19:27":if(guige==5)result=110;if(guige==10)result=210;if(guige==15)result=280;if(guige==20)result=370;if(guige==30)result=560;break;
			case "19:42":if(guige==5)result=110;if(guige==10)result=210;if(guige==15)result=280;if(guige==20)result=370;if(guige==30)result=560;break;
			case "19:56":if(guige==5)result=110;if(guige==10)result=210;if(guige==15)result=280;if(guige==20)result=370;if(guige==30)result=560;break;
			case "20:12":if(guige==5)result=70;if(guige==10)result=140;if(guige==15)result=210;if(guige==20)result=280;if(guige==30)result=420;break;
			case "20:27":if(guige==5)result=70;if(guige==10)result=140;if(guige==15)result=210;if(guige==20)result=280;if(guige==30)result=420;break;
			case "20:42":if(guige==5)result=70;if(guige==10)result=140;if(guige==15)result=210;if(guige==20)result=280;if(guige==30)result=420;break;
			case "20:56":if(guige==5)result=70;if(guige==10)result=140;if(guige==15)result=210;if(guige==20)result=280;if(guige==30)result=420;break;
			case "21:12":if(guige==5)result=70;if(guige==10)result=140;if(guige==15)result=210;if(guige==20)result=280;if(guige==30)result=420;break;
			case "21:27":if(guige==5)result=70;if(guige==10)result=140;if(guige==15)result=210;if(guige==20)result=280;if(guige==30)result=420;break;
			case "21:42":if(guige==5)result=70;if(guige==10)result=140;if(guige==15)result=210;if(guige==20)result=280;if(guige==30)result=420;break;
			case "21:56":if(guige==5)result=70;if(guige==10)result=140;if(guige==15)result=210;if(guige==20)result=280;if(guige==30)result=420;break;
			case "22:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "23:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "23:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "00:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "00:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "01:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "01:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "02:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "02:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "03:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "03:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "04:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "04:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "05:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "05:30":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "06:00":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "06:15":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
			case "06:27":if(guige==5)result=90;if(guige==10)result=140;if(guige==15)result=200;if(guige==20)result=340;if(guige==30)result=410;break;
		}
	}
	if(meiti2 == "FM91.6/吉林新闻综合广播") {
		switch (shiduan) {
                	case "07:00":if(guige==5)result=430;if(guige==10)result=770;if(guige==15)result=1200;if(guige==20)result=1600;if(guige==30)result=2300;break;
			case "07:37":if(guige==5)result=430;if(guige==10)result=770;if(guige==15)result=1200;if(guige==20)result=1600;if(guige==30)result=2300;break;
                        case "20:00":if(guige==5)result=430;if(guige==10)result=770;if(guige==15)result=1200;if(guige==20)result=1600;if(guige==30)result=2300;break;
                        case "20:28":if(guige==5)result=430;if(guige==10)result=770;if(guige==15)result=1200;if(guige==20)result=1600;if(guige==30)result=2300;break;
                        case "20:58":if(guige==5)result=430;if(guige==10)result=770;if(guige==15)result=1200;if(guige==20)result=1600;if(guige==30)result=2300;break;
                        case "21:28":if(guige==5)result=430;if(guige==10)result=770;if(guige==15)result=1200;if(guige==20)result=1600;if(guige==30)result=2300;break;
                        case "21:58":if(guige==5)result=430;if(guige==10)result=770;if(guige==15)result=1200;if(guige==20)result=1600;if(guige==30)result=2300;break;
                        case "06:00":if(guige==5)result=360;if(guige==10)result=660;if(guige==15)result=1000;if(guige==20)result=1500;if(guige==30)result=2000;break;
                        case "06:14":if(guige==5)result=360;if(guige==10)result=660;if(guige==15)result=1000;if(guige==20)result=1500;if(guige==30)result=2000;break;
                        case "06:27":if(guige==5)result=360;if(guige==10)result=660;if(guige==15)result=1000;if(guige==20)result=1500;if(guige==30)result=2000;break;
                        case "08:20":if(guige==5)result=360;if(guige==10)result=660;if(guige==15)result=1000;if(guige==20)result=1500;if(guige==30)result=2000;break;
                        case "08:58":if(guige==5)result=330;if(guige==10)result=630;if(guige==15)result=910;if(guige==20)result=1180;if(guige==30)result=1800;break;
                        case "09:28":if(guige==5)result=330;if(guige==10)result=630;if(guige==15)result=910;if(guige==20)result=1180;if(guige==30)result=1800;break;
                        case "09:58":if(guige==5)result=330;if(guige==10)result=630;if(guige==15)result=910;if(guige==20)result=1180;if(guige==30)result=1800;break;
                        case "12:28":if(guige==5)result=330;if(guige==10)result=630;if(guige==15)result=910;if(guige==20)result=1180;if(guige==30)result=1800;break;
                        case "13:28":if(guige==5)result=330;if(guige==10)result=630;if(guige==15)result=910;if(guige==20)result=1180;if(guige==30)result=1800;break;
                        case "16:58":if(guige==5)result=330;if(guige==10)result=630;if(guige==15)result=910;if(guige==20)result=1180;if(guige==30)result=1800;break;
                        case "17:28":if(guige==5)result=330;if(guige==10)result=630;if(guige==15)result=910;if(guige==20)result=1180;if(guige==30)result=1800;break;
                        case "17:58":if(guige==5)result=330;if(guige==10)result=630;if(guige==15)result=910;if(guige==20)result=1180;if(guige==30)result=1800;break;
                        case "04:28":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=710;if(guige==20)result=1000;if(guige==30)result=1500;break;
                        case "04:28":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=710;if(guige==20)result=1000;if(guige==30)result=1500;break;
                        case "04:58":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=710;if(guige==20)result=1000;if(guige==30)result=1500;break;
                        case "16:30":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=710;if(guige==20)result=1000;if(guige==30)result=1500;break;
                        case "18:26":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=710;if(guige==20)result=1000;if(guige==30)result=1500;break;
                        case "18:58":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=710;if(guige==20)result=1000;if(guige==30)result=1500;break;
                        case "22:28":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=710;if(guige==20)result=1000;if(guige==30)result=1500;break;
                        case "23:28":if(guige==5)result=250;if(guige==10)result=510;if(guige==15)result=710;if(guige==20)result=1000;if(guige==30)result=1500;break;
		}
	}
	if(meiti2 == "FM103.3/吉林旅游广播") {
		switch (shiduan) {
			case "07:16":if(guige==7)result=132;if(guige==15)result=385;if(guige==20)result=506;if(guige==30)result=700;
	                case "07:36":if(guige==7)result=132;if(guige==15)result=385;if(guige==20)result=506;if(guige==30)result=700; 
                        case "07:56":if(guige==7)result=132;if(guige==15)result=385;if(guige==20)result=506;if(guige==30)result=700;	
                        case "16:56":if(guige==7)result=132;if(guige==15)result=385;if(guige==20)result=506;if(guige==30)result=700;	
                        case "17:16":if(guige==7)result=132;if(guige==15)result=385;if(guige==20)result=506;if(guige==30)result=700;
                        case "08:16":if(guige==7)result=110;if(guige==15)result=330;if(guige==20)result=440;if(guige==30)result=660;	
                        case "08:36":if(guige==7)result=110;if(guige==15)result=330;if(guige==20)result=440;if(guige==30)result=660;	
                        case "08:56":if(guige==7)result=110;if(guige==15)result=330;if(guige==20)result=440;if(guige==30)result=660;
                        case "16:16":if(guige==7)result=110;if(guige==15)result=330;if(guige==20)result=440;if(guige==30)result=660;		
                        case "16:36":if(guige==7)result=110;if(guige==15)result=330;if(guige==20)result=440;if(guige==30)result=660;		
                        case "17:36":if(guige==7)result=110;if(guige==15)result=330;if(guige==20)result=440;if(guige==30)result=660;	
                        case "06:56":if(guige==7)result=88;if(guige==15)result=253;if(guige==20)result=330;if(guige==30)result=506;	
                        case "09:16":if(guige==7)result=88;if(guige==15)result=253;if(guige==20)result=330;if(guige==30)result=506;
                        case "06:36":if(guige==7)result=88;if(guige==15)result=253;if(guige==20)result=330;if(guige==30)result=506;
                        case "09:56":if(guige==7)result=88;if(guige==15)result=253;if(guige==20)result=330;if(guige==30)result=506;
                        case "10:16":if(guige==7)result=88;if(guige==15)result=253;if(guige==20)result=330;if(guige==30)result=506;
                        case "10:36":if(guige==7)result=88;if(guige==15)result=253;if(guige==20)result=330;if(guige==30)result=506;
                        case "10:56":if(guige==7)result=88;if(guige==15)result=253;if(guige==20)result=330;if(guige==30)result=506;
                        case "11:16":if(guige==7)result=88;if(guige==15)result=253;if(guige==20)result=330;if(guige==30)result=506;
                        case "11:36":if(guige==7)result=88;if(guige==15)result=253;if(guige==20)result=330;if(guige==30)result=506;
                        case "11:56":if(guige==7)result=88;if(guige==15)result=253;if(guige==20)result=330;if(guige==30)result=506;
                        case "18:16":if(guige==7)result=88;if(guige==15)result=253;if(guige==20)result=330;if(guige==30)result=506;
                        case "18:36":if(guige==7)result=88;if(guige==15)result=253;if(guige==20)result=330;if(guige==30)result=506;	
                        case "12:16":if(guige==7)result=66;if(guige==15)result=187;if(guige==20)result=264;if(guige==30)result=385;
                        case "12:36":if(guige==7)result=66;if(guige==15)result=187;if(guige==20)result=264;if(guige==30)result=385;
                        case "12:56":if(guige==7)result=66;if(guige==15)result=187;if(guige==20)result=264;if(guige==30)result=385;
                        case "13:26":if(guige==7)result=66;if(guige==15)result=187;if(guige==20)result=264;if(guige==30)result=385;
                        case "13:56":if(guige==7)result=66;if(guige==15)result=187;if(guige==20)result=264;if(guige==30)result=385;
                        case "18:56":if(guige==7)result=66;if(guige==15)result=187;if(guige==20)result=264;if(guige==30)result=385;
                        case "14:26":if(guige==7)result=66;if(guige==15)result=187;if(guige==20)result=264;if(guige==30)result=385;	
                        case "14:56":if(guige==7)result=66;if(guige==15)result=187;if(guige==20)result=264;if(guige==30)result=385;	
                        case "15:16":if(guige==7)result=66;if(guige==15)result=187;if(guige==20)result=264;if(guige==30)result=385;	
                        case "15:36":if(guige==7)result=66;if(guige==15)result=187;if(guige==20)result=264;if(guige==30)result=385;
                        case "15:56":if(guige==7)result=66;if(guige==15)result=187;if(guige==20)result=264;if(guige==30)result=385;	
                        case "05:56":if(guige==7)result=44;if(guige==15)result=132;if(guige==20)result=176;if(guige==30)result=264;
                        case "06:26":if(guige==7)result=44;if(guige==15)result=132;if(guige==20)result=176;if(guige==30)result=264;
                        case "19:16":if(guige==7)result=44;if(guige==15)result=132;if(guige==20)result=176;if(guige==30)result=264;
                        case "19:36":if(guige==7)result=44;if(guige==15)result=132;if(guige==20)result=176;if(guige==30)result=264;
                        case "19:56":if(guige==7)result=44;if(guige==15)result=132;if(guige==20)result=176;if(guige==30)result=264;
                        case "20:26":if(guige==7)result=44;if(guige==15)result=132;if(guige==20)result=176;if(guige==30)result=264;
                        case "20:56":if(guige==7)result=44;if(guige==15)result=132;if(guige==20)result=176;if(guige==30)result=264;
                        case "21:26":if(guige==7)result=44;if(guige==15)result=132;if(guige==20)result=176;if(guige==30)result=264;
                        case "21:56":if(guige==7)result=44;if(guige==15)result=132;if(guige==20)result=176;if(guige==30)result=264;
                        case "22:26":if(guige==7)result=44;if(guige==15)result=132;if(guige==20)result=176;if(guige==30)result=264;
                        case "22:56":if(guige==7)result=44;if(guige==15)result=132;if(guige==20)result=176;if(guige==30)result=264;
                        case "23:26":if(guige==7)result=44;if(guige==15)result=132;if(guige==20)result=176;if(guige==30)result=264;
                        case "23:56":if(guige==7)result=44;if(guige==15)result=132;if(guige==20)result=176;if(guige==30)result=264;
		}
	}
	if(meiti2 == "FM96.3/吉林教育广播") {
		switch (shiduan) {
			case "07:27":if(guige==7)result=180;if(guige==15)result=380;if(guige==20)result=500;if(guige==30)result=770;break;
			case "07:57":if(guige==7)result=180;if(guige==15)result=380;if(guige==20)result=500;if(guige==30)result=770;break;
			case "16:57":if(guige==7)result=180;if(guige==15)result=380;if(guige==20)result=500;if(guige==30)result=770;break;
			case "17:27":if(guige==7)result=180;if(guige==15)result=380;if(guige==20)result=500;if(guige==30)result=770;break;
			case "08:27":if(guige==7)result=150;if(guige==15)result=330;if(guige==20)result=440;if(guige==30)result=660;break;
			case "08:57":if(guige==7)result=150;if(guige==15)result=330;if(guige==20)result=440;if(guige==30)result=660;break;
			case "16:27":if(guige==7)result=150;if(guige==15)result=330;if(guige==20)result=440;if(guige==30)result=660;break;
			case "17:57":if(guige==7)result=150;if(guige==15)result=330;if(guige==20)result=440;if(guige==30)result=660;break;
			case "06:57":if(guige==7)result=130;if(guige==15)result=260;if(guige==20)result=330;if(guige==30)result=500;break;
			case "09:27":if(guige==7)result=130;if(guige==15)result=260;if(guige==20)result=330;if(guige==30)result=500;break;
			case "09:57":if(guige==7)result=130;if(guige==15)result=260;if(guige==20)result=330;if(guige==30)result=500;break;
			case "10:27":if(guige==7)result=130;if(guige==15)result=260;if(guige==20)result=330;if(guige==30)result=500;break;
			case "10:57":if(guige==7)result=130;if(guige==15)result=260;if(guige==20)result=330;if(guige==30)result=500;break;
			case "11:27":if(guige==7)result=130;if(guige==15)result=260;if(guige==20)result=330;if(guige==30)result=500;break;
			case "11:57":if(guige==7)result=130;if(guige==15)result=260;if(guige==20)result=330;if(guige==30)result=500;break;
			case "18:27":if(guige==7)result=130;if(guige==15)result=260;if(guige==20)result=330;if(guige==30)result=500;break;
			case "12:27":if(guige==7)result=100;if(guige==15)result=190;if(guige==20)result=270;if(guige==30)result=390;break;
			case "12:57":if(guige==7)result=100;if(guige==15)result=190;if(guige==20)result=270;if(guige==30)result=390;break;
			case "13:27":if(guige==7)result=100;if(guige==15)result=190;if(guige==20)result=270;if(guige==30)result=390;break;
			case "18:57":if(guige==7)result=100;if(guige==15)result=190;if(guige==20)result=270;if(guige==30)result=390;break;
			case "13:57":if(guige==7)result=100;if(guige==15)result=190;if(guige==20)result=270;if(guige==30)result=390;break;
			case "14:27":if(guige==7)result=100;if(guige==15)result=190;if(guige==20)result=270;if(guige==30)result=390;break;
			case "14:57":if(guige==7)result=100;if(guige==15)result=190;if(guige==20)result=270;if(guige==30)result=390;break;
			case "15:27":if(guige==7)result=100;if(guige==15)result=190;if(guige==20)result=270;if(guige==30)result=390;break;
			case "15:57":if(guige==7)result=100;if(guige==15)result=190;if(guige==20)result=270;if(guige==30)result=390;break;
			case "06:27":if(guige==7)result=60;if(guige==15)result=140;if(guige==20)result=180;if(guige==30)result=270;break;
			case "19:27":if(guige==7)result=60;if(guige==15)result=140;if(guige==20)result=180;if(guige==30)result=270;break;
			case "19:57":if(guige==7)result=60;if(guige==15)result=140;if(guige==20)result=180;if(guige==30)result=270;break;
			case "20:27":if(guige==7)result=60;if(guige==15)result=140;if(guige==20)result=180;if(guige==30)result=270;break;
			case "20:57":if(guige==7)result=60;if(guige==15)result=140;if(guige==20)result=180;if(guige==30)result=270;break;
			case "21:27":if(guige==7)result=50;if(guige==15)result=110;if(guige==20)result=140;if(guige==30)result=190;break;
			case "21:57":if(guige==7)result=50;if(guige==15)result=110;if(guige==20)result=140;if(guige==30)result=190;break;
			case "22:27":if(guige==7)result=50;if(guige==15)result=110;if(guige==20)result=140;if(guige==30)result=190;break;
			case "22:57":if(guige==7)result=50;if(guige==15)result=110;if(guige==20)result=140;if(guige==30)result=190;break;
			case "23:27":if(guige==7)result=50;if(guige==15)result=110;if(guige==20)result=140;if(guige==30)result=190;break;
		}
	}
	if(meiti2 == "FM101.9/吉林健康娱乐广播") {
		switch (shiduan) {
			case "07:25":if(guige==10)result=230;if(guige==20)result=440;if(guige==30)result=650;break;
			case "08:25":if(guige==10)result=230;if(guige==20)result=440;if(guige==30)result=650;break;
			case "10:28":if(guige==10)result=230;if(guige==20)result=440;if(guige==30)result=650;break;
			case "11:28":if(guige==10)result=180;if(guige==20)result=340;if(guige==30)result=500;break;
			case "12:28":if(guige==10)result=180;if(guige==20)result=340;if(guige==30)result=500;break;
			case "12:55":if(guige==10)result=180;if(guige==20)result=340;if(guige==30)result=500;break;
			case "16:28":if(guige==10)result=180;if(guige==20)result=340;if(guige==30)result=500;break;
			case "13:58":if(guige==10)result=110;if(guige==20)result=230;if(guige==30)result=320;break;
			case "14:58":if(guige==10)result=110;if(guige==20)result=230;if(guige==30)result=320;break;
			case "19:28":if(guige==10)result=110;if(guige==20)result=230;if(guige==30)result=320;break;
			case "20:28":if(guige==10)result=110;if(guige==20)result=230;if(guige==30)result=320;break;
		}
	}
	if(meiti2 == "FM97.6/吉林乡村广播") {
		switch (shiduan) {
			case "09:55":if(guige==10)result=290;if(guige==20)result=580;if(guige==30)result=870;break;
			case "09:55":if(guige==10)result=290;if(guige==20)result=580;if(guige==30)result=870;break;
			case "10:20":if(guige==10)result=230;if(guige==20)result=440;if(guige==30)result=650;break;
			case "12:25":if(guige==10)result=230;if(guige==20)result=440;if(guige==30)result=650;break;
			case "12:55":if(guige==10)result=230;if(guige==20)result=440;if(guige==30)result=650;break;
			case "17:55":if(guige==10)result=230;if(guige==20)result=440;if(guige==30)result=650;break;
			case "06:55":if(guige==10)result=180;if(guige==20)result=340;if(guige==30)result=500;break;
			case "07:25":if(guige==10)result=180;if(guige==20)result=340;if(guige==30)result=500;break;
			case "07:55":if(guige==10)result=180;if(guige==20)result=340;if(guige==30)result=500;break;
			case "08:25":if(guige==10)result=180;if(guige==20)result=340;if(guige==30)result=500;break;
			case "16:55":if(guige==10)result=130;if(guige==20)result=250;if(guige==30)result=380;break;
			case "18:25":if(guige==10)result=130;if(guige==20)result=250;if(guige==30)result=380;break;
			case "18:55":if(guige==10)result=130;if(guige==20)result=250;if(guige==30)result=380;break;
			case "14:55":if(guige==10)result=95;if(guige==20)result=180;if(guige==30)result=250;break;
			case "15:25":if(guige==10)result=95;if(guige==20)result=180;if(guige==30)result=250;break;
			case "15:55":if(guige==10)result=95;if(guige==20)result=180;if(guige==30)result=250;break;
			case "21:25":if(guige==10)result=95;if(guige==20)result=180;if(guige==30)result=250;break;
			case "21:55":if(guige==10)result=95;if(guige==20)result=180;if(guige==30)result=250;break;
		}
	}
	if(meiti2 == "FM95.3/吉林经济广播") {
		switch (shiduan) {
			case "07:25":if(guige==10)result=350;if(guige==15)result=510;if(guige==20)result=680;if(guige==30)result=1050;break;
			case "07:55":if(guige==10)result=350;if(guige==15)result=510;if(guige==20)result=680;if(guige==30)result=1050;break;
			case "08:25":if(guige==10)result=350;if(guige==15)result=510;if(guige==20)result=680;if(guige==30)result=1050;break;
			case "09:30":if(guige==10)result=250;if(guige==15)result=380;if(guige==20)result=510;if(guige==30)result=750;break;
			case "10:25":if(guige==10)result=250;if(guige==15)result=380;if(guige==20)result=510;if(guige==30)result=750;break;
			case "11:55":if(guige==10)result=250;if(guige==15)result=380;if(guige==20)result=510;if(guige==30)result=750;break;
			case "12:25":if(guige==10)result=190;if(guige==15)result=300;if(guige==20)result=380;if(guige==30)result=580;break;
			case "12:55":if(guige==10)result=190;if(guige==15)result=300;if(guige==20)result=380;if(guige==30)result=580;break;
			case "14:25":if(guige==10)result=190;if(guige==15)result=300;if(guige==20)result=380;if(guige==30)result=580;break;
			case "15:55":if(guige==10)result=150;if(guige==15)result=220;if(guige==20)result=300;if(guige==30)result=450;break;
			case "16:55":if(guige==10)result=150;if(guige==15)result=220;if(guige==20)result=300;if(guige==30)result=450;break;
			case "17:25":if(guige==10)result=150;if(guige==15)result=220;if(guige==20)result=300;if(guige==30)result=450;break;
			case "17:55":if(guige==10)result=150;if(guige==15)result=220;if(guige==20)result=300;if(guige==30)result=450;break;
			case "18:25":if(guige==10)result=95;if(guige==15)result=160;if(guige==20)result=200;if(guige==30)result=300;break;
			case "18:55":if(guige==10)result=95;if(guige==15)result=160;if(guige==20)result=200;if(guige==30)result=300;break;
		}
	}
	return result;
}