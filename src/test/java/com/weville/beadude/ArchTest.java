package com.weville.beadude;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.weville.beadude");

        noClasses()
            .that()
            .resideInAnyPackage("com.weville.beadude.service..")
            .or()
            .resideInAnyPackage("com.weville.beadude.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.weville.beadude.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
