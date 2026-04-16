package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.entity.house.BrickHouse;
import ru.geardroid.designpatterns.entity.house.WoodenHouse;
import ru.geardroid.designpatterns.pattern.decorator.InsuranceHouseDecorator;
import ru.geardroid.designpatterns.pattern.decorator.SmartHouseDecorator;

import static org.assertj.core.api.Assertions.assertThat;

class DecoratorTest {

    @Test
    void givenWoodenHouseWithAndWithoutInsurance_whenGetPriceDiff_thenCorrectPrice() {
        // given:
        var woodenHouse = new WoodenHouse();
        var woodenHouseWithInsurance = new InsuranceHouseDecorator(woodenHouse);
        // when:
        var priceDiff = woodenHouseWithInsurance.getPrice() - woodenHouse.getPrice();
        // then:
        assertThat(priceDiff).isEqualTo(InsuranceHouseDecorator.INSURANCE_PRICE);
    }

    @Test
    void givenBrickHouseWithAndWithoutSmartHouse_whenGetPriceDiff_thenCorrectPrice() {
        // given:
        var brickHouse = new BrickHouse();
        var brickHouseWithSmartHouse = new SmartHouseDecorator(brickHouse);
        // when:
        var priceDiff = brickHouseWithSmartHouse.getPrice() - brickHouse.getPrice();
        // then:
        assertThat(priceDiff).isEqualTo(SmartHouseDecorator.SMART_HOUSE_PRICE);
    }

    @Test
    void givenBrickHouseWithInsuranceAndSmartHouse_whenGetPrice_thenCorrectPrice() {
        // given:
        var house = new SmartHouseDecorator(new InsuranceHouseDecorator(new BrickHouse()));
        var expectedPrice = BrickHouse.PRICE
                + InsuranceHouseDecorator.INSURANCE_PRICE
                + SmartHouseDecorator.SMART_HOUSE_PRICE;
        // when:
        var price = house.getPrice();
        // then:
        assertThat(price).isEqualTo(expectedPrice);
    }
}
