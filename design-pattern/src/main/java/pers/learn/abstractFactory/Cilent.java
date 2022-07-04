package pers.learn.abstractFactory;

public class Cilent {
    public static void main(String[] args) {

        System.out.println("=======xiaomi==============");
        MiFactory miFactory = new MiFactory();
        PhoneProduct miPhone = miFactory.phoneProduct();
        miPhone.powerOn();
        miPhone.shutdown();
        miPhone.callup();
        miPhone.sms();

        RouterProduct miRouter = miFactory.routerProduct();
        miRouter.powerOn();
        miRouter.openWiFi();

        System.out.println("========huawei===========");
        HwFactory hwFactory = new HwFactory();
        PhoneProduct hwPhone = hwFactory.phoneProduct();
        hwPhone.powerOn();

        RouterProduct hwRouter = hwFactory.routerProduct();
        hwRouter.powerOn();
        hwRouter.openWiFi();

    }
}
