
# 🔍 Kotlin Vulnerable Demo Project (Trivy-compatible)

Ce projet Kotlin est un exemple minimal contenant des dépendances **vulnérables connues**. Il permet de démontrer l’utilisation de **Trivy** pour détecter les **CVE** dans les bibliothèques tierces via les fichiers `dependency-locks`.

---

## 🧱 Stack utilisée

- Kotlin + Gradle (DSL Kotlin)
- Trivy (scanner de vulnérabilités)
- Dépendances vulnérables : 
  - `log4j-core:2.14.1` → CVE-2021-44228
  - `jackson-databind:2.9.9` → CVE-2019-12384

---

## 🚀 Installation

```bash
git clone https://github.com/Eomoz5620/kotlin-sample.git
cd kotlin-trivy-demo
```

---

## 🛠️ Préparer le projet

1. **Configurer les verrous de dépendances** dans `build.gradle.kts` :

```kotlin
dependencyLocking {
    lockAllConfigurations()
}
```

2. **Générer les fichiers lock** :

```bash
gradle dependencies --write-locks
```

Cela génère les fichiers `.lock` dans `gradle/dependency-locks/`.

---

## 🔍 Scanner avec Trivy

> Assure-toi d’avoir la dernière version de Trivy installée.

### Scan simple :

```bash
trivy fs . --scanners vuln --pkg-types gradle
```

### Scan avec filtrage par sévérité :

```bash
trivy fs . --scanners vuln --pkg-types gradle --severity CRITICAL,HIGH
```

### Optionnel : afficher le résultat en tableau

```bash
trivy fs . --scanners vuln --pkg-types gradle --format table
```

---

## ✅ Résultat attendu

Trivy détecte les vulnérabilités des bibliothèques définies dans les fichiers `.lock` :

| Library                  | CVE               | Severity |
|--------------------------|-------------------|----------|
| log4j-core:2.14.1        | CVE-2021-44228    | CRITICAL |
| jackson-databind:2.9.9   | CVE-2019-12384    | HIGH     |

---

## 🧹 Nettoyage

```bash
gradle clean
rm -rf ~/.cache/trivy  # (optionnel) pour forcer un nouveau scan complet
```

---

## 📎 Liens utiles

- [Trivy Documentation](https://aquasecurity.github.io/trivy/latest/)
- [CVE Log4Shell](https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2021-44228)
- [CVE Jackson](https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2019-12384)
