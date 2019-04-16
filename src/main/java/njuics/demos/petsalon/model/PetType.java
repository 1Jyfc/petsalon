package njuics.demos.petsalon.model;

public enum PetType {
  CAT("猫"), DOG("狗"), RABBIT("兔子");

  private final String name;

  private PetType(String name)
  {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
