param(
    [string]$FilePath
)

# 编译
javac -encoding UTF-8 $FilePath

if ($LASTEXITCODE -eq 0) {
    # 提取包名和类名
    $relativePath = $FilePath.Replace("$PWD\", "").Replace("$PWD/", "")
    $className = $relativePath.Replace("src\", "").Replace("src/", "").Replace("\", ".").Replace("/", ".").Replace(".java", "")
    
    # 运行
    Set-Location src
    java $className
    Set-Location ..
}

