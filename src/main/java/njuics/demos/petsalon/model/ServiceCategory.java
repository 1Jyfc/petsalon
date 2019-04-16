package njuics.demos.petsalon.model;

public enum ServiceCategory {
  CLEAN("清洁"), FEED("喂食"), CURE("治疗");

  private final String name;

  private ServiceCategory(String name)
  {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
