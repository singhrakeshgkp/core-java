# Builder Pattern
<p>
Separate the construction of a complex object from its representation so that same construction process can create different representation.
</p>

- Builder pattern helps us in creating immutable classess with large set of state attributes.
- Implementation is provided in ```BuilderPatternExample.java``` class.
- It Avoid telescoping constructors problem

### Example in java api
- Stream.Builder
- IntStream.Builder
- LongStream.Builder
- DoubleStream.Builder
- Locale aLocale = new Builder().setLanguage("sr").setScript("Latn").setRegion("RS").build();
- Calendar cal = new Calendar.Builder().setCalendarType("iso8601")
                        .setWeekDate(2022, 1, Sunday).build();
