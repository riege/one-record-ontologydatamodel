package org.iata.onerecord.cargo.util;

import org.iata.onerecord.cargo.Vocabulary;
import org.iata.onerecord.cargo.model.LogisticsObject;
import org.iata.onerecord.cargo.model.Waybill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ONERecordCargoUtilTest {
    @Test
    void testCreate() {
        Waybill obj = ONERecordCargoUtil.create(Waybill.class);
        Assertions.assertTrue(obj instanceof Waybill);
        Assertions.assertEquals(1, obj.getTypes().size());
        String type = (String) obj.getTypes().toArray()[0];
        Assertions.assertEquals(Vocabulary.s_c_Waybill, type);

        type = (String) ONERecordCargoUtil.create(LogisticsObject.class)
            .getTypes().toArray()[0];
        Assertions.assertEquals(Vocabulary.s_c_LogisticsObject, type);
    }
}
