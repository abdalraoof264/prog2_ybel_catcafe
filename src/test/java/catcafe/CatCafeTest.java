package catcafe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CatCafeTest {

  @Test
  void givenEmptyCafe_whenGetCatCount_thenReturnsZero() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    long count = cafe.getCatCount();

    // then
    assertEquals(0, count);
  }

  @Test
  void givenEmptyCafe_whenGetCatByName_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    FelineOverLord cat = cafe.getCatByName("Gwenapurr Esmeralda");

    // then
    assertNull(cat);
  }

  @Test
  void givenEmptyCafe_whenGetCatByWeight_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    FelineOverLord cat = cafe.getCatByWeight(1, 5);

    // then
    assertNull(cat);
  }

  @Test
  void givenOneCat_whenAddCat_thenCatCountIsOne() {
    // given
    CatCafe cafe = new CatCafe();
    FelineOverLord cat = new FelineOverLord("Minka", 4);

    // when
    cafe.addCat(cat);

    // then
    assertEquals(1, cafe.getCatCount());
  }

  @Test
  void givenMultipleCats_whenAddCats_thenCatCountMatchesNumberOfCats() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    cafe.addCat(new FelineOverLord("Minka", 4));
    cafe.addCat(new FelineOverLord("Luna", 3));
    cafe.addCat(new FelineOverLord("Simba", 6));

    // then
    assertEquals(3, cafe.getCatCount());
  }

  @Test
  void givenNullCat_whenAddCat_thenThrowsNullPointerException() {
    // given
    CatCafe cafe = new CatCafe();

    // when / then
    assertThrows(NullPointerException.class, () -> cafe.addCat(null));
  }

  @Test
  void givenCafeWithCat_whenGetCatByExistingName_thenReturnsThatCat() {
    // given
    CatCafe cafe = new CatCafe();
    FelineOverLord cat = new FelineOverLord("Luna", 3);
    cafe.addCat(cat);

    // when
    FelineOverLord foundCat = cafe.getCatByName("Luna");

    // then
    assertSame(cat, foundCat);
  }

  @Test
  void givenCafeWithCat_whenGetCatByUnknownName_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 3));

    // when
    FelineOverLord foundCat = cafe.getCatByName("Garfield");

    // then
    assertNull(foundCat);
  }

  @Test
  void givenCafeWithCat_whenGetCatByNullName_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 3));

    // when
    FelineOverLord foundCat = cafe.getCatByName(null);

    // then
    assertNull(foundCat);
  }

  @Test
  void givenCafeWithCats_whenGetCatByWeightInRange_thenReturnsCatWithinRange() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Minka", 2));
    cafe.addCat(new FelineOverLord("Luna", 4));
    cafe.addCat(new FelineOverLord("Simba", 7));

    // when
    FelineOverLord foundCat = cafe.getCatByWeight(3, 6);

    // then
    assertTrue(foundCat.weight() >= 3);
    assertTrue(foundCat.weight() < 6);
  }

  @Test
  void givenCafeWithCats_whenGetCatByWeightBelowZero_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 4));

    // when
    FelineOverLord foundCat = cafe.getCatByWeight(-1, 5);

    // then
    assertNull(foundCat);
  }

  @Test
  void givenCafeWithCats_whenGetCatByWeightMaxSmallerThanMin_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 4));

    // when
    FelineOverLord foundCat = cafe.getCatByWeight(6, 3);

    // then
    assertNull(foundCat);
  }

  @Test
  void givenCafeWithCatAtMaxWeight_whenGetCatByWeight_thenMaxWeightIsExclusive() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 5));

    // when
    FelineOverLord foundCat = cafe.getCatByWeight(1, 5);

    // then
    assertNull(foundCat);
  }
}
