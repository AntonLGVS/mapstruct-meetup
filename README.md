# Материал к митапу по MapStruct

MapStruct - процеессор аннотаций и поэтому его работу можно увидеть в сгенерированных классах.

---

Процесс исследования:

1. Скомпилировать проект`./mvnw comlipe`
2. Перейти в папку `./target/generated-sources/annotations/*`

> Если в коде используется зависимость Lombok, то процессор аннотаций Lombok должен исполняться до MapStruct
> ```xml
> <annotationProcessorPaths>
>   <path> <!-- MUST BE FIRST -->
>       <groupId>org.projectlombok</groupId>
>       <artifactId>lombok</artifactId>
>       <version>${lombok.version}</version>
>   </path>
>   <path>
>       <groupId>org.mapstruct</groupId>
>       <artifactId>mapstruct-processor</artifactId>
>       <version>${mapstruct.version}</version>
>   </path>
> </annotationProcessorPaths>
>```

[Презентация](https://github.com/AntonLGVS/mapstruct-meetup/blob/master/MapStruct.pdf)
