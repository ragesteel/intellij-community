/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.openapi.vcs.changes.actions.diff;

import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.UserDataHolder;
import com.intellij.openapi.util.diff.chains.DiffRequestPresentableException;
import com.intellij.openapi.util.diff.requests.DiffRequest;
import com.intellij.openapi.vcs.changes.Change;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ChangeDiffRequestProvider {
  ExtensionPointName<ChangeDiffRequestProvider> EP_NAME =
    ExtensionPointName.create("com.intellij.openapi.vcs.changes.actions.diff.ChangeDiffRequestProvider");

  boolean canCreate(@NotNull Project project, @NotNull Change change);

  /*
   * Method should return null if change is of different type and throw exception on error
   */
  @NotNull
  DiffRequest process(@NotNull ChangeDiffRequestPresentable presentable,
                      @NotNull UserDataHolder context,
                      @NotNull ProgressIndicator indicator) throws DiffRequestPresentableException, ProcessCanceledException;
}
