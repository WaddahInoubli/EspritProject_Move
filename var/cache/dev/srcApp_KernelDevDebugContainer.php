<?php

// This file has been auto-generated by the Symfony Dependency Injection Component for internal use.

if (\class_exists(\Container7rnDZ3h\srcApp_KernelDevDebugContainer::class, false)) {
    // no-op
} elseif (!include __DIR__.'/Container7rnDZ3h/srcApp_KernelDevDebugContainer.php') {
    touch(__DIR__.'/Container7rnDZ3h.legacy');

    return;
}

if (!\class_exists(srcApp_KernelDevDebugContainer::class, false)) {
    \class_alias(\Container7rnDZ3h\srcApp_KernelDevDebugContainer::class, srcApp_KernelDevDebugContainer::class, false);
}

return new \Container7rnDZ3h\srcApp_KernelDevDebugContainer([
    'container.build_hash' => '7rnDZ3h',
    'container.build_id' => '7d4c4b27',
    'container.build_time' => 1681255484,
], __DIR__.\DIRECTORY_SEPARATOR.'Container7rnDZ3h');
