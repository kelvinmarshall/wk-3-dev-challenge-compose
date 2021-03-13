package com.example.androiddevchallenge.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.FavoriteItem
import com.example.androiddevchallenge.ui.components.ImageListItem
import com.example.androiddevchallenge.ui.components.InputTextField
import com.example.androiddevchallenge.ui.data.Data
import com.example.androiddevchallenge.ui.data.alignYourBody
import com.example.androiddevchallenge.ui.data.alignYourMind
import com.example.androiddevchallenge.ui.data.favoriteCollections
import com.example.androiddevchallenge.ui.theme.Elevation
import com.example.androiddevchallenge.ui.theme.MyTheme


/**
 * Created by Kevin Macharia on 3/13/21.
 * Turnkey Africa LTD
 * kevin.macharia@turnkeyafrica.com
 */

sealed class NavItem(val title: String, val icon: ImageVector) {
    object Home : NavItem("Home", Icons.Filled.Spa)
    object Profile : NavItem("Profile", Icons.Filled.AccountCircle)
}

val navItems = listOf(
    NavItem.Home,
    NavItem.Profile,
)


@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier) {
            Scaffold(
                bottomBar = { BottomNav() },
            ) {

                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxSize(),
                ) {
                    InputTextField(
                        modifier = Modifier.padding(top = 56.dp, end = 16.dp),
                        leadingIcon = { SearchIcon() },
                        placeHolderText = stringResource(id = R.string.search)
                    )

                    HorizontalRow(titleRes = R.string.favorite_collection) {
                        FavouriteRow()
                    }
                    HorizontalRow(titleRes = R.string.align_your_body) {
                        ImageListRow(list = alignYourBody)
                    }
                    HorizontalRow(titleRes = R.string.align_your_mind) {
                        ImageListRow(list = alignYourMind)
                    }

                }
            }

            PlayFab()
        }
    }
}

@Composable
fun SearchIcon() {
    Icon(
        Icons.Filled.Search,
        contentDescription = null,
        modifier = Modifier.size(18.dp),
    )
}

@Composable
fun BottomNav() {
    BottomNavigation(
        elevation = Elevation.bottomNavigationElevation,
        modifier = Modifier.height(56.dp),
        backgroundColor = MaterialTheme.colors.background
    ) {
        navItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint = MaterialTheme.colors.onBackground

                    )
                },
                label = {
                    Text(
                        item.title,
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onBackground,
                    )
                },
                selected = item == NavItem.Home,
                onClick = {}
            )
        }
    }
}

@Composable
fun HorizontalRow(
    titleRes: Int,
    content: @Composable () -> Unit
) {
    CategoryTitle(titleRes = titleRes)
    content()
}


@ExperimentalFoundationApi
@Composable
fun FavouriteRow() {
    LazyRow() {
        items(favoriteCollections.size) {
            if (it < favoriteCollections.size / 2)
                Column {
                    val item1 = favoriteCollections[it * 2]
                    FavoriteItem(item1.title, item1.image)
                    val item2 = favoriteCollections[it * 2 + 1]
                    FavoriteItem(item2.title, item2.image)
                }
        }
    }

}

@Composable
fun ImageListRow(list: List<Data>) {
    LazyRow {
        items(list) { favourite ->
            ImageListItem(title = favourite.title, image = favourite.image)
        }
    }

}

@Composable
fun CategoryTitle(titleRes: Int) {
    Text(
        stringResource(id = titleRes),
        style = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.onBackground,
        modifier = Modifier
            .paddingFromBaseline(top = 40.dp)
            .fillMaxWidth(),
    )
}

@Composable
fun PlayFab() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 28.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .clickable {  },
            color = MaterialTheme.colors.primary,
        ) {
            Image(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
            )
        }
    }
}


@ExperimentalFoundationApi
@Preview
@Composable
fun HomeScreenPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            HomeScreen()
        }

    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun HomeScreenPreviewDark() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            HomeScreen()
        }

    }
}

