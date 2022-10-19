package pers.learn;

import org.junit.Test;
import pers.learn.utils.Patt;

public class PattTest {
    @Test
    public void test(){
        Patt patt = new Patt();

        String line = "86233268,86233263,2,Optical,1,2,3,Available,Reserved,\"REM \\Ra,ck 19\"\" Indoor\",24773332[00000-0001#0001][00000-0012#0001][00000-0001#0001],M,65";
        line =",,DSL FO-LV1975,DSL FO-LV1975,000000224856#000000224980,77865.5081,84022.6492,DSL,Active,,\"REM Ra,ck 19\"\" Indoor\",49.69074804,6.13854221,False,False,a,,,2018-12-31,2023-12-31,Migration reguliere,,,,,HB_DEV,C,Hybrid,00,PTECH,0,0,POP 133,Device,2009-10-07,,,M,Terminal,CENTER,InService,A,,,33,DSL FO-LV1975,-9,100022,DN2107220938552242,DN2107211741891177,1C,8,DO2110221425058942,210721172806881580,";
        String line1 = patt.convertLine(line, ",");
        System.out.println(line1);
        line ="25427425,DSL FO-LV1975,000000224856#000000224980,77865.5081,84022.6492,Hybrid,33,DSL,Active,Device,,\"REM Rack 19\"\" Indoor\",False,False,49.69074804,6.13854221,False,False,InService,Available,,,2018-12-31,2023-12-31,Migration reguliere,,,,,POP 133,2009-10-07,,,CENTER,,,M";
        line1 = patt.convertLine(line, ",");
        System.out.println(line1);
        line ="100010039,67534465,67534810,613538,613538,,False,0.00,InService,Reserved,,,SystemUser:07/10/2022[CR][LF]·Circuit: 14316110020 XDS14316110020[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14316110020 XDS14316110020[CR][LF]·Device: sigi_redangeattert.nd.dt.ept.lu[CR][LF]·Port: \\WAN\\WAN[CR][LF]·Address: 000000096135#000000000000,,M,39";
        line1 = patt.convertLine(line, ",");
        System.out.println(line1);
        line ="44765817,35,1049033,Copper,Available,Reserved,SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]·Device: mowo_bereldange.nd.dt.ept.lu[CR][LF]·Port: \\VDSL2\\WAN[CR][LF]·Address: 000000016211#000000000000SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]·Device: mowo_bereldange.nd.dt.ept.lu[CR][LF]·Port: \\VDSL2\\WAN[CR][LF]·Address: 000000016211#000000000000SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]·Device: mowo_bereldange.nd.dt.ept.lu[CR][LF]·Port: \\VDSL2\\WAN[CR][LF]·Address: 000000016211#000000000000SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]·Device: mowo_bereldange.nd.dt.ept.lu[CR][LF]·Port: \\VDSL2\\WAN[CR][LF]·Address: 000000016211#000000000000SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]·Device: mowo_bereldange.nd.dt.ept.lu[CR][LF]·Port: \\VDSL2\\WAN[CR][LF]·Address: 000000016211#000000000000SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]·Device: mowo_bereldange.nd.dt.ept.lu[CR][LF]·Port: \\VDSL2\\WAN[CR][LF]·Address: 000000016211#000000000000SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]·Device: mowo_bereldange.nd.dt.ept.lu[CR][LF]·Port: \\VDSL2\\WAN[CR][LF]·Address: 000000016211#000000000000SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]·Device: mowo_bereldange.nd.dt.ept.lu[CR][LF]·Port: \\VDSL2\\WAN[CR][LF]·Address: 000000016211#000000000000SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]·Device: mowo_bereldange.nd.dt.ept.lu[CR][LF]·Port: \\VDSL2\\WAN[CR][LF]·Address: 000000016211#000000000000SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]·Device: mowo_bereldange.nd.dt.ept.lu[CR][LF]·Port: \\VDSL2\\WAN[CR][LF]·Address: 000000016211#000000000000SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]·Device: mowo_bereldange.nd.dt.ept.lu[CR][LF]·Port: \\VDSL2\\WAN[CR][LF]·Address: 000000016211#000000000000SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]·Device: mowo_bereldange.nd.dt.ept.lu[CR][LF]·Port: \\VDSL2\\WAN[CR][LF]·Address: 000000016211#000000000000SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]SystemUser:07/10/2022[CR][LF]·Circuit: 14313310030 XDS14313310030[CR][LF]·Device: mowo_bereldange.nd.dt.ept.lu[CR][LF]·Port: \\VDSL2\\WAN[CR][LF]·Address: 000000016211#000000000000,1049033[00001-0047#0001],M,46\n";
        line1 = patt.convertLine(line, ",");
        System.out.println(line1);
    }

}
